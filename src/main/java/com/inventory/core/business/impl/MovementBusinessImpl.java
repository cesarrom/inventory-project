package com.inventory.core.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.core.business.BusinessesIndex;
import com.inventory.core.business.MovementBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.models.Movement;
import com.inventory.models.MovementDetail;
import com.inventory.models.MovementType;
import com.inventory.models.Product;
import com.inventory.models.ProductRepository;
import com.inventory.models.dto.MovementDetailDto;
import com.inventory.models.dto.MovementDto;
import com.inventory.models.query.MovementQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class MovementBusinessImpl implements MovementBusiness {

	private DaoIndex daos;
	private BusinessesIndex businesses;

	@Autowired
	public MovementBusinessImpl(DaoIndex daos, BusinessesIndex businesses) {
		this.daos = daos;
		this.businesses = businesses;
	}

	@Override
	public Movement rollbackMovement(Long parentMovementId, MovementDto headerInfo) {
		String[] movementDetailIncludes = { "product" };
		Movement parentMovement = this.find(parentMovementId);
		Movement rollbackMovement = headerInfo.fillCrudModel();
		rollbackMovement.setMovement(parentMovement);
		MovementType beforeMovementType = parentMovement.getMovementType();
		Long newSourceRepositoryId = beforeMovementType.getSourceRepository().getId();
		Long newTargetRepositoryId = beforeMovementType.getTargetRepository().getId();
		MovementType newMovementType = this.businesses.getMovementTypeBusiness()
				.findBySourceAndTargetRepository(newSourceRepositoryId, newTargetRepositoryId, true);
		rollbackMovement.setMovementType(newMovementType);
		if (parentMovement.getMovementDetails().size() > 0) {
			rollbackMovement
					.setMovementDetails(parentMovement.getMovementDetails().parallelStream().map(movementDetail -> {
						MovementDetailDto movementDetailDto = movementDetail.fillDtoModel(movementDetailIncludes);
						movementDetailDto.setId(null);
						return movementDetailDto.fillCrudModel(movementDetailIncludes);
					}).collect(Collectors.toList()));
		}
		return this.generateMovement(rollbackMovement);
	}

	@Override
	public Movement partiallyRollbackMovement(Long movementId, List<MovementDetailDto> rollbackMovements,
			MovementDto headerInfo) {
		String[] movementDetailIncludes = { "product" };
		Movement parentMovement = this.find(movementId);
		Movement rollbackMovement = headerInfo.fillCrudModel();
		rollbackMovement.setMovement(parentMovement);
		MovementType beforeMovementType = parentMovement.getMovementType();
		Long newSourceRepositoryId = beforeMovementType.getSourceRepository().getId();
		Long newTargetRepositoryId = beforeMovementType.getTargetRepository().getId();
		MovementType newMovementType = this.businesses.getMovementTypeBusiness()
				.findBySourceAndTargetRepository(newSourceRepositoryId, newTargetRepositoryId);
		rollbackMovement.setMovementType(newMovementType);
		if (parentMovement.getMovementDetails().size() > 0) {
			rollbackMovement.setMovementDetails(rollbackMovements.parallelStream().map(movementDetail -> {
				return movementDetail.fillCrudModel(movementDetailIncludes);
			}).collect(Collectors.toList()));
		}
		return this.generateMovement(rollbackMovement);
	}

	@Override
	public Movement generateMovement(MovementDto movementInfo) {
		return this.generateMovement(this.daos.getMovementDao().create(movementInfo
				.fillCrudModel(new String[] { "movementType", "movementDetails", "movementDetails.product" })));

	}

	@Transactional(propagation = Propagation.REQUIRED)
	private Movement generateMovement(Movement movement) {
		MovementType movementType = this.businesses.getMovementTypeBusiness().find(movement.getMovementType().getId());
		movement.setMovementType(movementType);
		if (movementType.getParentMovementRequired() && ObjectUtils.isFalsey(movement.getMovement())) {
			throw new BadRequestException("PARENT MOVEMENT IS REQUIRED FOR THIS PROCESS");
		} else if (movementType.getParentMovementRequired()) {
			Movement parentMovement = this.find(movement.getMovement().getId());
			if (ObjectUtils.isThruthy(parentMovement.getCustomer())) {
				movement.setCustomer(parentMovement.getCustomer());
			} else if (ObjectUtils.isThruthy(parentMovement.getSupplier())) {
				movement.setSupplier(parentMovement.getSupplier());
			}
			movement.setMovement(parentMovement);
		} else if (ObjectUtils.isThruthy(movement.getSupplier())) {
			movement.setSupplier(this.businesses.getSupplierBusiness().find(movement.getSupplier().getId()));
		} else if (ObjectUtils.isThruthy(movement.getCustomer())) {
			movement.setCustomer(this.businesses.getCustomerBusiness().find(movement.getCustomer().getId()));
		} else {
			throw new BadRequestException("A MOVEMENT HAVE TO ALWAYS BE ASSOCIATED WITH A CUSTOMER OR A SUPPLIER");
		}
		Long targetRepositoryId = movementType.getTargetRepository().getId();
		Long sourceRepositoryId = movementType.getSourceRepository().getId();
		List<MovementDetail> movementDetails = movement.getMovementDetails();
		movement.setMovementDetails(movementDetails.parallelStream().map(unsavedMovementDetail -> {
			Product product = this.businesses.getProductBusiness().find(unsavedMovementDetail.getProduct().getId());
			ProductRepository sourceProductRepository = this.businesses.getProductRepositoryBusiness()
					.findOrCreateByProductIdAndRepositoryId(product.getId(), sourceRepositoryId,
							unsavedMovementDetail.getValue() / unsavedMovementDetail.getQuantity());
			ProductRepository targetProductRepository = this.businesses.getProductRepositoryBusiness()
					.findOrCreateByProductIdAndRepositoryId(product.getId(), targetRepositoryId,
							unsavedMovementDetail.getValue() / unsavedMovementDetail.getQuantity());
			if (sourceProductRepository.getCurrentQuantity() - unsavedMovementDetail.getQuantity() < 0) {
				throw new BadRequestException("THE SOURCE REPOSITORY [" + sourceRepositoryId
						+ "] HAVE NOT ENOUGH PRODUCT [" + product.getId() + "] TO GET FROM");
			}
			sourceProductRepository.setCurrentQuantity(
					sourceProductRepository.getCurrentQuantity() - unsavedMovementDetail.getQuantity());
			targetProductRepository.setCurrentQuantity(
					targetProductRepository.getCurrentQuantity() + unsavedMovementDetail.getQuantity());
			this.daos.getMovementDetailDao().create(unsavedMovementDetail);
			unsavedMovementDetail.setSourceProductRepository(sourceProductRepository);
			unsavedMovementDetail.setTargetProductRepository(targetProductRepository);
			if (unsavedMovementDetail.getQuantity() > 0 && unsavedMovementDetail.getValue() > 0) {
				unsavedMovementDetail
						.setDiscountPercentage(((product.getBasePrice() * unsavedMovementDetail.getQuantity())
								/ unsavedMovementDetail.getValue()) * 100);
			} else if (unsavedMovementDetail.getValue() > 0) {
				unsavedMovementDetail.setDiscountPercentage(100);
			} else {
				unsavedMovementDetail.setDiscountPercentage(0);
			}
			unsavedMovementDetail.setProduct(product);
			unsavedMovementDetail.setMovement(movement);
			return unsavedMovementDetail;
		}).collect(Collectors.toList()));
		return movement;
	}

	@Override
	public List<Movement> list(MovementQuery query) {
		return this.daos.getMovementDao().list(query);
	}

	@Override
	public Movement find(Long movementId) {
		return this.daos.getMovementDao().findById(movementId)
				.orElseThrow(() -> new BadRequestException("NO MOVEMENT WAS FOUND WITH ID [" + movementId + "]"));
	}

}

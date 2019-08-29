package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.BusinessesIndex;
import com.inventory.core.business.MovementDetailBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.MovementDetail;
import com.inventory.models.dto.MovementDetailDto;
import com.inventory.models.query.MovementDetailQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class MovementDetailBusinessImpl implements MovementDetailBusiness {

	private DaoIndex daos;
	private BusinessesIndex businesses;

	@Autowired
	public MovementDetailBusinessImpl(DaoIndex daos, BusinessesIndex businesses) {
		this.daos = daos;
		this.businesses = businesses;
	}

	@Override
	public MovementDetail create(MovementDetailDto movementDetail) {
		/*
		 * private ProductRepositoryDto sourceProductRepository;
		 * 
		 * // bi-directional many-to-one association to MovementDto
		 * 
		 * private ProductRepositoryDto targetProductRepository;
		 * 
		 * // bi-directional many-to-one association to MovementDto
		 * 
		 * private MovementDto movement;
		 * 
		 * // bi-directional many-to-one association to ProductDto
		 * 
		 * private ProductDto product;
		 */
		if (ObjectUtils.isFalsey(movementDetail))
			throw new BadRequestException("THE MOVEMENT DETAIL OBJECT CANNOT BE NULL!");
		if (ObjectUtils.isFalsey(movementDetail.getMovement()))
			throw new BadRequestException("YOU MUST PROVIDE A MOVEMENT PARENT TO CREATE A MOVEMENT DETAIL!");
		if (ObjectUtils.isFalsey(movementDetail.getProduct()))
			throw new BadRequestException("YOU MUST PROVIDE A PRODUCT TO CREATE A MOVEMENT DETAIL!");
		if (ObjectUtils.isFalsey(movementDetail.getSourceProductRepository()))
			throw new BadRequestException("YOU MUST PROVIDE A SOURCE PRODUCT REPOSITORY TO CREATE A MOVEMENT DETAIL!");
		if (ObjectUtils.isFalsey(movementDetail.getSourceProductRepository()))
			throw new BadRequestException("YOU MUST PROVIDE A TARGET PRODUCT REPOSITORY TO CREATE A MOVEMENT DETAIL!");
		MovementDetail crudMovementDetail = this.daos.getMovementDetailDao().create(movementDetail.fillCrudModel());
		crudMovementDetail
				.setMovement(this.businesses.getMovementBusiness().find(movementDetail.getMovement().getId()));
		crudMovementDetail
		.setProduct(this.businesses.getProductBusiness().find(movementDetail.getProduct().getId()));
		return crudMovementDetail;
	}

	@Override
	public List<MovementDetail> list(MovementDetailQuery query) {
		return this.daos.getMovementDetailDao().list(query);
	}

	@Override
	public MovementDetail update(Long movementDetailId, MovementDetailDto movementDetailParams) {
		MovementDetail movementDetail = this.daos.getMovementDetailDao().findById(movementDetailId)
				.orElseThrow(() -> new NotFoundException("MOVEMENT DETAIL NOT FOUND [id:" + movementDetailId + "]"));
		ObjectUtils.copyPropertiesIgnoringNulls(movementDetailParams, movementDetail);
		this.daos.getMovementDetailDao().update(movementDetail);
		return movementDetail;
	}

	@Override
	public MovementDetail find(Long movementDetailId) {
		return this.daos.getMovementDetailDao().findById(movementDetailId)
				.orElseThrow(() -> new NotFoundException("MOVEMENT DETAIL NOT FOUND [id:" + movementDetailId + "]"));
	}

}

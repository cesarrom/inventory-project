package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.SupplierBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.Supplier;
import com.inventory.models.dto.SupplierDto;
import com.inventory.models.query.SupplierQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class SupplierBusinessImpl implements SupplierBusiness {
	
	private DaoIndex daos;
	@Autowired
	public SupplierBusinessImpl(DaoIndex daos) {
		this.daos = daos;
	}

	@Override
	public Supplier create(SupplierDto supplier) {
		return this.daos.getSupplierDao().create(supplier.fillCrudModel());
	}

	@Override
	public List<Supplier> list(SupplierQuery query) {
		return this.daos.getSupplierDao().list(query);
	}

	@Override
	public Supplier update(Long supplierId, SupplierDto supplierParams) {
		Supplier supplier = this.find(supplierId);
		ObjectUtils.copyPropertiesIgnoringNulls(supplierParams, supplier);
		this.daos.getSupplierDao().update(supplier);
		return supplier;
	}

	@Override
	public Supplier find(Long supplierId) {
		return this.daos.getSupplierDao().findById(supplierId).orElseThrow(() -> new NotFoundException("SUPPLIER NOT FOUND [id:"+supplierId+"]"));
	}

	
}

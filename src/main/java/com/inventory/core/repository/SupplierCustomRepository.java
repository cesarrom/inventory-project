package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.Supplier;
import com.inventory.models.query.SupplierQuery;

public interface SupplierCustomRepository {
	public List<Supplier> list(SupplierQuery queryParams);
}

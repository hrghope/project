package org.hrghope.warehouse.service;

import org.hrghope.warehouse.exception.WarehouseException;
import org.hrghope.warehouse.model.Device;
import org.hrghope.warehouse.model.Warehouse;
import org.hrghope.warehouse.model.WarehouseState;

public interface WarehouseService {

	Warehouse in(Device device) throws WarehouseException;

	Warehouse out(String code, String outCompanyName) throws WarehouseException;

	/**
	 * find {@link Warehouse} recode ,null means not found
	 * 
	 * @param code
	 * @param state
	 * @return
	 */
	Warehouse findByStateAndDevCode(String code, WarehouseState state) throws WarehouseException;

	WarehouseQueryResult listByParam(WarehouseQueryParam warehouseQueryParam);
}

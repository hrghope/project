package net.vicp.hrghope.warehouse.service;

import net.vicp.hrghope.warehouse.exception.WarehouseException;
import net.vicp.hrghope.warehouse.model.Device;
import net.vicp.hrghope.warehouse.model.Warehouse;
import net.vicp.hrghope.warehouse.model.WarehouseState;

public interface WarehouseService {

	Warehouse in(Device device) throws WarehouseException;

	Warehouse out(String code) throws WarehouseException;

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

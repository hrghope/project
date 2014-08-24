package net.vicp.hrghope.warehouse.dal.dao;

import java.util.List;

import net.vicp.hrghope.warehouse.exception.WarehouseException;
import net.vicp.hrghope.warehouse.model.Warehouse;
import net.vicp.hrghope.warehouse.model.WarehouseState;
import net.vicp.hrghope.warehouse.service.WarehouseQueryParam;

public interface WarehouseDao {

	void save(Warehouse warehouse) throws WarehouseException;

	void update(Warehouse warehouse) throws WarehouseException;

	/**
	 * find {@link Warehouse} recode ,null means not found
	 * 
	 * @param code
	 * @param state
	 * @return
	 */
	Warehouse findByStateAndDevCode(String code, WarehouseState state) throws WarehouseException;

	List<Warehouse> listByParam(WarehouseQueryParam param);

	Integer countByParam(WarehouseQueryParam param);

}

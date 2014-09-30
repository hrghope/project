package org.hrghope.warehouse.dal.dao;

import java.util.List;

import org.hrghope.warehouse.exception.WarehouseException;
import org.hrghope.warehouse.model.Warehouse;
import org.hrghope.warehouse.model.WarehouseState;
import org.hrghope.warehouse.service.WarehouseQueryParam;

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

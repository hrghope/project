package net.vicp.hrghope.warehouse.dal.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.vicp.hrghope.warehouse.model.Warehouse;
import net.vicp.hrghope.warehouse.model.WarehouseState;

public interface WarehouseMapper {
	@Select("select * from warehouse where code=#{code} and state=#{state}")
	Warehouse findByCode(@Param(value = "code") String code,@Param(value = "state") WarehouseState state);
}

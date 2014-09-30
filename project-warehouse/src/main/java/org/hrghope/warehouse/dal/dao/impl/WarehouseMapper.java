package org.hrghope.warehouse.dal.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hrghope.warehouse.model.Warehouse;
import org.hrghope.warehouse.model.WarehouseState;

public interface WarehouseMapper {
	@Select("select * from warehouse where code=#{code} and state=#{state}")
	Warehouse findByCode(@Param(value = "code") String code,@Param(value = "state") WarehouseState state);
}

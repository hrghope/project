package net.vicp.hrghope.warehouse.dal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.vicp.hrghope.warehouse.dal.dao.WarehouseDao;
import net.vicp.hrghope.warehouse.exception.WarehouseException;
import net.vicp.hrghope.warehouse.model.Warehouse;
import net.vicp.hrghope.warehouse.model.WarehouseState;
import net.vicp.hrghope.warehouse.service.WarehouseQueryParam;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

@Service
public class WarehouseDaoImpl extends SqlSessionDaoSupport implements WarehouseDao {

	public Warehouse findByStateAndDevCode(String code, WarehouseState state) {
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("dev_code", code);
		queryParam.put("state", state);
		Warehouse warehouse = getSqlSession().selectOne("warehouse.selectByStateAndDevCode", queryParam);
		return warehouse;
	}

	public void save(Warehouse warehouse) throws WarehouseException {
		int insert = getSqlSession().insert("warehouse.insert", warehouse);

		if (insert != 1) {
			// error
		}

	}

	public void update(Warehouse warehouse) throws WarehouseException {
		int update = getSqlSession().update("warehouse.update", warehouse);

		if (update != 1) {
			// error
		}
	}

	public List<Warehouse> listByParam(WarehouseQueryParam param) {
		return getSqlSession().selectList("warehouse.selectByParam", param);
	}

	public Integer countByParam(WarehouseQueryParam param) {
		return getSqlSession().selectOne("warehouse.countByParam", param);
	}

}

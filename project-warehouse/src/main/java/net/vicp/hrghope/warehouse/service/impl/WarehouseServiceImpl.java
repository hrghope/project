package net.vicp.hrghope.warehouse.service.impl;

import java.util.Date;
import java.util.List;

import net.vicp.hrghope.warehouse.dal.dao.WarehouseDao;
import net.vicp.hrghope.warehouse.exception.DeviceAlreadyInWarehouseException;
import net.vicp.hrghope.warehouse.exception.InWarehouseNotFoundException;
import net.vicp.hrghope.warehouse.exception.WarehouseException;
import net.vicp.hrghope.warehouse.model.Device;
import net.vicp.hrghope.warehouse.model.Warehouse;
import net.vicp.hrghope.warehouse.model.WarehouseState;
import net.vicp.hrghope.warehouse.service.WarehouseQueryParam;
import net.vicp.hrghope.warehouse.service.WarehouseQueryResult;
import net.vicp.hrghope.warehouse.service.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;

	public Warehouse in(Device device) throws WarehouseException {
		Warehouse warehouse = findByStateAndDevCode(device.getCode(), WarehouseState.IN);
		if (warehouse != null) {
			throw new DeviceAlreadyInWarehouseException(device.getCode());
		}
		warehouse = new Warehouse();
		warehouse.setDevice(device);
		warehouse.setInDate(new Date());
		warehouse.setState(WarehouseState.IN);
		warehouseDao.save(warehouse);

		return warehouse;

	}

	public Warehouse out(String code, String outCompanyName) throws WarehouseException {
		Warehouse warehouse = findByStateAndDevCode(code, WarehouseState.IN);

		if (warehouse == null) {
			throw new InWarehouseNotFoundException(code);
		}

		warehouse.setOutDate(new Date());
		warehouse.setOutCompanyName(outCompanyName);
		warehouse.setState(WarehouseState.OUT);
		warehouseDao.update(warehouse);
		return warehouse;

	}

	public Warehouse findByStateAndDevCode(String code, WarehouseState state) throws WarehouseException {
		return warehouseDao.findByStateAndDevCode(code, state);
	}

	public WarehouseQueryResult listByParam(WarehouseQueryParam warehouseQueryParam) {
		List<Warehouse> warehouses = warehouseDao.listByParam(warehouseQueryParam);
		Integer count = warehouseDao.countByParam(warehouseQueryParam);
		return new WarehouseQueryResult(warehouses, count);
	}

}

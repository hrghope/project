package net.vicp.hrghope.warehouse.test;

import org.hrghope.warehouse.exception.WarehouseException;
import org.hrghope.warehouse.model.Device;
import org.hrghope.warehouse.model.Warehouse;
import org.hrghope.warehouse.model.WarehouseState;
import org.hrghope.warehouse.service.WarehouseService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WarehouseServiceTest extends AbstractTestCase {
	@Autowired
	private WarehouseService warehouseService;

	@Test
	public void test() throws WarehouseException {
		String code = "400";
		Device dev = new Device();
		dev.setCode(code);
		dev.setType("type_100");
		Warehouse warehouse = warehouseService.in(dev);
		Assert.assertNotNull(warehouse.getId());

		Warehouse warehouse2 = warehouseService.findByStateAndDevCode(code, WarehouseState.IN);
		Assert.assertNotNull(warehouse2.getId());

		Warehouse warehouse3 = warehouseService.out(code,"sss");
		
		Assert.assertNotNull(warehouse3.getOutDate());
		Assert.assertEquals(WarehouseState.OUT, warehouse3.getState());
	}
}

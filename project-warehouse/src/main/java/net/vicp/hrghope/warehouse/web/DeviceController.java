package net.vicp.hrghope.warehouse.web;

import java.util.List;

import net.vicp.hrghope.warehouse.exception.WarehouseException;
import net.vicp.hrghope.warehouse.model.Device;
import net.vicp.hrghope.warehouse.model.Warehouse;
import net.vicp.hrghope.warehouse.service.WarehouseQueryParam;
import net.vicp.hrghope.warehouse.service.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 设备维度
 * 
 * @author ronggang.huangrg
 * 
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends AbstractController {
	@Autowired
	private WarehouseService warehouseService;

	/**
	 * 入库
	 * 
	 * @throws WarehouseException
	 */
	@RequestMapping("/{devCode}/in")
	@ResponseBody
	public Result<Warehouse> in(@PathVariable("devCode") String devCode, @RequestParam(value = "devType", required = false) String devType) throws WarehouseException {
		Device device = new Device();
		device.setCode(devCode);
		device.setType(devType);
		Warehouse warehouse = warehouseService.in(device);
		return buildResult(warehouse);
	}

	/**
	 * 出库
	 * 
	 * @param devCode
	 * @return
	 * @throws WarehouseException
	 */
	@RequestMapping("/{devCode}/out")
	@ResponseBody
	public Result<Warehouse> out(@PathVariable("devCode") String devCode) throws WarehouseException {
		Warehouse warehouse = warehouseService.out(devCode);
		return buildResult(warehouse);
	}

	/**
	 * 罗列某个设备的进出库历史
	 * 
	 * @return
	 */
	@RequestMapping("/{devCode}/list")
	@ResponseBody
	public Result<List<Warehouse>> listByParam(@PathVariable("devCode") String devCode) {
		WarehouseQueryParam param = new WarehouseQueryParam();
		param.devCode(devCode);
		List<Warehouse> warehouses = warehouseService.listByParam(param).getWarehouses();
		return buildResult(warehouses);
	}

	// /**
	// * 返回待入库的记录
	// *
	// * @param devCode
	// * @return
	// */
	// @RequestMapping("/{devCode}")
	// @ResponseBody
	// public Result find(@PathVariable("devCode") String devCode) {
	// WarehouseQueryParam param = new WarehouseQueryParam();
	// param.setDevCode(devCode).state(WarehouseState.IN);// 只需要已入库
	// List<Warehouse> list = warehouseService.listByParam(param);
	//
	// if (list != null && list.size() == 1) {
	// return buildResult(list.get(0));
	// }
	// return null;
	// }
}

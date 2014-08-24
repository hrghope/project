package net.vicp.hrghope.warehouse.web;

import java.util.Date;

import net.vicp.hrghope.warehouse.model.WarehouseState;
import net.vicp.hrghope.warehouse.service.WarehouseQueryParam;
import net.vicp.hrghope.warehouse.service.WarehouseQueryResult;
import net.vicp.hrghope.warehouse.service.WarehouseService;
import net.vicp.hrghope.warehouse.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 仓库维度
 * 
 * @author ronggang.huangrg
 * 
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController extends AbstractController {
	@Autowired
	private WarehouseService warehouseService;

	/**
	 * 罗列某个仓库某个日期的进出记录
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Result<WarehouseQueryResult> list(@RequestParam(required = false) String devCode, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyyMMdd") Date inDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyyMMdd") Date outDate, @RequestParam(required = false) WarehouseState state, @RequestParam(defaultValue = "0") int pageIndex,
			@RequestParam(defaultValue = "15") int pageSize) {
		WarehouseQueryParam param = new WarehouseQueryParam();
		param.devCode(devCode);
		param.inDateBefore(DateUtil.getDayEnd(inDate)).inDateAfter(DateUtil.getDayBegin(inDate));
		param.outDateBefore(DateUtil.getDayEnd(outDate)).outDateAfter(DateUtil.getDayEnd(outDate)).state(state);
		param.startRow(pageIndex * pageSize).offset(pageSize);
		WarehouseQueryResult warehouseQueryResult = warehouseService.listByParam(param);
		warehouseQueryResult.setPageIndex(pageIndex);
		warehouseQueryResult.setPageSize(pageSize);
		warehouseQueryResult.setPageCount(warehouseQueryResult.getCount() % pageSize == 0 ? warehouseQueryResult.getCount() / pageSize : warehouseQueryResult.getCount() / pageSize + 1);
		return buildResult(warehouseQueryResult);
	}

}

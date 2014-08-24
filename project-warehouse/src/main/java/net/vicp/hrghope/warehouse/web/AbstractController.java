package net.vicp.hrghope.warehouse.web;

import net.vicp.hrghope.warehouse.exception.WarehouseException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class AbstractController {
	<T extends Object>Result<T> buildResult(T obj) {
		return new Result<T>(true, null, obj);
	}

	@ExceptionHandler(WarehouseException.class)
	@ResponseBody
	public Result<?> handleException(WarehouseException ex) {
		return new Result(false, ex.getMessage(), null);
	}
}

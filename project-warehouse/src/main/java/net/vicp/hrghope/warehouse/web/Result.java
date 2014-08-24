package net.vicp.hrghope.warehouse.web;

public class Result<T extends Object> {
	private final boolean succeed;

	private final String errorMsg;

	private final T model;

	public Result(boolean succeed, String errorMsg, T model) {
		super();
		this.succeed = succeed;
		this.errorMsg = errorMsg;
		this.model = model;
	}

	public boolean isSucceed() {
		return succeed;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public T getModel() {
		return model;
	}

}

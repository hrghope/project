package net.vicp.hrghope.warehouse.exception;

public class DeviceAlreadyInWarehouseException extends WarehouseException {

	private static final long serialVersionUID = 8623540099221678249L;
	private String devCode;

	private final String MSG = "设备：%s 已经入库了";

	public DeviceAlreadyInWarehouseException(String devCode) {
		super();
		this.devCode = devCode;
	}

	@Override
	public String getMessage() {
		return String.format(MSG, devCode);
	}

}

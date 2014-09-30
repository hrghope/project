package net.vicp.hrghope.warehouse.model;

import java.util.Date;

/**
 * 仓库
 * 
 * @author ronggang.huangrg
 * 
 */
public class Warehouse {
	private Long id;

	/**
	 * 设备
	 */
	private Device device;

	/**
	 * 入库时间
	 */
	private Date inDate;

	/**
	 * 出库时间
	 */
	private Date outDate;

	private WarehouseState state;

	private String outCompanyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public WarehouseState getState() {
		return state;
	}

	public void setState(WarehouseState state) {
		this.state = state;
	}

	public String getOutCompanyName() {
		return outCompanyName;
	}

	public void setOutCompanyName(String outCompanyName) {
		this.outCompanyName = outCompanyName;
	}

}

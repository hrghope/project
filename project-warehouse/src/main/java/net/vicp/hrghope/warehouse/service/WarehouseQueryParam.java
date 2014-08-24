package net.vicp.hrghope.warehouse.service;

import java.util.Date;

import net.vicp.hrghope.warehouse.model.WarehouseState;

public class WarehouseQueryParam {
	private String devCode;

	private WarehouseState state;

	private Date inDateBefore;

	private Date inDateAfter;

	private Date outDateBefore;

	private Date outDateAfter;

	private Integer startRow;

	private Integer offset;

	public String getDevCode() {
		return devCode;
	}

	public WarehouseQueryParam devCode(String devCode) {
		this.devCode = devCode;
		return this;
	}

	public Date getInDateBefore() {
		return inDateBefore;
	}

	public WarehouseQueryParam inDateBefore(Date inDateBefore) {
		this.inDateBefore = inDateBefore;
		return this;
	}

	public Date getInDateAfter() {
		return inDateAfter;
	}

	public WarehouseQueryParam inDateAfter(Date inDateAfter) {
		this.inDateAfter = inDateAfter;
		return this;
	}

	public WarehouseState getState() {
		return state;
	}

	public WarehouseQueryParam state(WarehouseState state) {
		this.state = state;
		return this;
	}

	public Date getOutDateBefore() {
		return outDateBefore;
	}

	public WarehouseQueryParam outDateBefore(Date outDateBefore) {
		this.outDateBefore = outDateBefore;
		return this;
	}

	public Date getOutDateAfter() {
		return outDateAfter;
	}

	public WarehouseQueryParam outDateAfter(Date outDateAfter) {
		this.outDateAfter = outDateAfter;
		return this;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public WarehouseQueryParam startRow(Integer startRow) {
		this.startRow = startRow;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public WarehouseQueryParam offset(Integer offset) {
		this.offset = offset;
		return this;
	}

}

package org.hrghope.warehouse.service;

import java.util.List;

import org.hrghope.warehouse.model.Warehouse;

public class WarehouseQueryResult {
	private final List<Warehouse> warehouses;

	private final Integer count;

	private int pageIndex;

	private int pageCount;

	private int pageSize;

	public WarehouseQueryResult(List<Warehouse> warehouses, Integer count) {
		super();
		this.warehouses = warehouses;
		this.count = count;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public Integer getCount() {
		return count;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}

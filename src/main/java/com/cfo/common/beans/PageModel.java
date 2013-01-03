package com.cfo.common.beans;

import java.util.List;


/**
 * 分页封装类
 * @author xuyl
 * @date 2012-12-12
 * @param <T>
 */
public class PageModel<T> {
	private int pageNo = 1;
	private int pageSize = 15;
	private int totalRecords;
	
	private String sort;		// 排序
	private List<T> result;		// 数据集合
	
	public int getTotalPages() {
		return (this.totalRecords + this.pageSize - 1) / this.pageSize;
	}
	
	public int getFirstPageNo() {
		return 1;
	}
	
	public int getLastPageNo() {
		return this.getTotalPages();
	}
	
	public int getPreviousPageNo() {
		if (this.pageNo <= 1) {
			return 1;
		}
		return this.pageNo - 1;
	}

	public int getNextPageNo() {
		if (this.pageNo >= this.getLastPageNo()) {
			return this.getLastPageNo();
		}
		return this.pageNo + 1;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getFirstIndex() {
		return (pageNo - 1) * pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}

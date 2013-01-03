package com.cfo.common.beans;

/**
 * Ext分页参数<br/>
 * page:	第几页<br/>
 * start:	开始记录号<br/>
 * limit:	一页几条<br/>
 * sort:	那个字段排序<br/>
 * dir:		ASC/DESC
 * @author xuyl
 * @date 2013-1-23
 */
public class ExtParam {
	private Integer page;	// 第几页
	private Integer start;	// 开始记录号
	private Integer limit;	// 一页几条
	private String sort;	// 那个字段排序
	private String dir;		// ASC/DESC

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "ExtParam [page=" + page + ", start=" + start + ", limit=" + limit + ", sort=" + sort + ", dir=" + dir
				+ "]";
	}
}

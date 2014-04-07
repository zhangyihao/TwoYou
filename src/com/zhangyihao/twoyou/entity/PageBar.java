package com.zhangyihao.twoyou.entity;

public class PageBar {
	private static Integer pageSize = 5;
	private Integer nextPage;
	private Integer prevPage;
	private Integer lastPage;
	private Integer totalRecord;
	private Integer totalPage;
	
	public static Integer getPageSize() {
		return pageSize;
	}	
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}

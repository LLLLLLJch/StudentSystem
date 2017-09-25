package com.situ.student.vo;

public class FindCourseByCondition {

	private String name;
	private String credit;
	private Integer pageIndex;
	private Integer pageSize;
	
	
	public FindCourseByCondition() {
		super();
	}
	public FindCourseByCondition(String name, String credit, Integer pageIndex, Integer pageSize) {
		super();
		this.name = name;
		this.credit = credit;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "FindCourseByCondition [name=" + name + ", credit=" + credit + ", pageIndex=" + pageIndex + ", pageSize="
				+ pageSize + "]";
	}
	
	
}

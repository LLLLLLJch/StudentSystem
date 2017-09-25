package com.situ.student.vo;

public class FindByCondition {

	private String name;
	private String age;
	private String gender;
	private Integer pageIndex;
	private Integer pageSize;
	
	public FindByCondition() {
		super();
	}
	public FindByCondition(String name, String age, String gender, Integer pageIndex, Integer pageSize) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
		return "FindByCondition [name=" + name + ", age=" + age + ", gender=" + gender + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + "]";
	}
	
	
}

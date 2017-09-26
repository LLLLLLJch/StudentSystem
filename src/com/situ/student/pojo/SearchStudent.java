package com.situ.student.pojo;

import java.util.Date;

public class SearchStudent {

	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private Date birthday;
	private String banjiName;
	private String courseName;
	private Integer credit;
	
	public SearchStudent() {
		super();
	}
	public SearchStudent(String name, Integer age, String gender, String address, Date birthday, String banjiName,
			String courseName, Integer credit) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banjiName = banjiName;
		this.courseName = courseName;
		this.credit = credit;
	}
	public SearchStudent(Integer id, String name, Integer age, String gender, String address, Date birthday,
			String banjiName, String courseName, Integer credit) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banjiName = banjiName;
		this.courseName = courseName;
		this.credit = credit;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBanjiName() {
		return banjiName;
	}
	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "SearchStudent [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + ", birthday=" + birthday + ", banjiName=" + banjiName + ", courseName=" + courseName
				+ ", credit=" + credit + "]";
	}
	
	
}

package com.situ.student.pojo;

public class Admit {

	private Integer id;
	private String name;
	private String password;
	
	public Admit() {
		super();
	}
	public Admit(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admit [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}

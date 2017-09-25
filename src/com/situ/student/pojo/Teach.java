package com.situ.student.pojo;

public class Teach {

	private Integer banjiId;
	private String banjiName;
	private String courseName;
	
	public Teach() {
		super();
	}
	
	public Teach(Integer banjiId, String banjiName, String courseName) {
		super();
		this.banjiId = banjiId;
		this.banjiName = banjiName;
		this.courseName = courseName;
	}

	public Integer getBanjiId() {
		return banjiId;
	}
	public void setBanjiId(Integer banjiId) {
		this.banjiId = banjiId;
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

	@Override
	public String toString() {
		return "Teach [banjiId=" + banjiId + ", banjiName=" + banjiName + ", courseName=" + courseName + "]";
	}
	
	
}

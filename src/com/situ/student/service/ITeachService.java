package com.situ.student.service;

import java.util.List;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.SearchStudent;
import com.situ.student.pojo.Student;
import com.situ.student.pojo.Teach;

public interface ITeachService {

	List<Student> findAll();

	void addCourse(int parseInt, int parseInt2);

	List<Teach> pageBean(List<Banji> list);

	List<Banji> teach();

	void delCourse(int parseInt, int parseInt2);

	List<Student> findByName(String studentName);

	List<SearchStudent> changeStudentInfo(List<Student> oldList);


}

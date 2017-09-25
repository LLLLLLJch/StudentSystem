package com.situ.student.service;

import java.util.List;
import java.util.Map;

import com.situ.student.exception.NameException;
import com.situ.student.pojo.Student;
import com.situ.student.vo.FindByCondition;
import com.situ.student.vo.PageBean;

public interface IStudentService {

	List<Student> findAll();

	void deleteStudent(int id);

	Student findById(int parseInt);

	void updateStudent(Student student);

	void addStudents(Student student) throws NameException;

	int checkName(String name);

	PageBean<Student> getPageBean(int pageIndex, int pageSize);

	PageBean<Student> findCondition(FindByCondition condition);

	void deleteAll(int[] ids);

}

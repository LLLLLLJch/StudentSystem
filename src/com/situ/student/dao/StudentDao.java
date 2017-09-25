package com.situ.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.student.pojo.Student;
import com.situ.student.vo.FindByCondition;

public interface StudentDao {

	List<Student> findAll();
	
	void deleteStudent(int id);
	
	Student findById(int id);
	
	void updateStudent(Student student);

	void addStudents(Student student);

	int checkName(String name);

	int totalCount();

	List<Student> pageBeanList(@Param(value="pageIndex")int pageIndex, @Param(value="pageSize")int pageSize);

	int totalCountByCondition(FindByCondition condition);

	List<Student> findCondition(Map<Object, Object> map);
}

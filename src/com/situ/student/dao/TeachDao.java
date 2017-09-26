package com.situ.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.SearchStudent;
import com.situ.student.pojo.Student;

public interface TeachDao {

	List<Banji> pageBeanList(@Param(value="pageIndex")int pageIndex, @Param(value="pageSize")int pageSize);

	List<Student> findAll();

	void addCourse(@Param(value="banjiId")int banjiId, @Param(value="addCourse")int addCourse);

	List<Banji> teach();

	void delCourse(@Param(value="banjiId")int banjiId, @Param("delCourse")int delCourse);

	List<Student> findByName(String studentName);


}

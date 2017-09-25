package com.situ.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.student.pojo.Course;
import com.situ.student.vo.FindCourseByCondition;

public interface CourseDao {

	int totalCount();

	List<Course> pageBeanList(@Param(value="pageIndex")int pageIndex, @Param(value="pageSize")int pageSize);

	List<Course> findAll();

	List<Course> pageBeanListByCondition(Map<Object, Object> map);

	int totalCountByCondition(FindCourseByCondition findCourseByCondition);

	void delete(int id);

	void add(@Param(value="name")String name, @Param(value="credit")String credit);

	Course findById(int id);

	void update(Course course);
	
	
}

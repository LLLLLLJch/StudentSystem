package com.situ.student.service;

import java.util.List;

import com.situ.student.pojo.Course;
import com.situ.student.vo.FindCourseByCondition;
import com.situ.student.vo.PageBean;

public interface ICourseService {

	PageBean<Course> pageBean(int pageIndex, int pageSize);

	List<Course> findAll();

	PageBean<Course> pageBean(FindCourseByCondition findCourseByCondition);

	void delete(int id);

	void add(String name, String credit);

	Course findById(int id);

	void update(Course course);

}

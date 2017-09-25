package com.situ.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.situ.student.dao.BanjiDao;
import com.situ.student.dao.CourseDao;
import com.situ.student.pojo.Course;
import com.situ.student.service.ICourseService;
import com.situ.student.vo.FindCourseByCondition;
import com.situ.student.vo.PageBean;

@Service("courseService")
public class CourseServiceImpl implements ICourseService{

	@Resource(name="courseDao")
	private CourseDao courseDao;
	
	@Override
	public PageBean<Course> pageBean(int pageIndex, int pageSize) {
		PageBean<Course> pageBean = new PageBean<Course>();
		// 当前页
		// private Integer pageIndex;
		pageBean.setPageIndex(pageIndex);
		// 当前页显示的条数
		// private Integer pageSize;
		pageBean.setPageSize(pageSize);
		// 总条数
		// private Integer totalCount;
		int totalCount = courseDao.totalCount();
		pageBean.setTotalCount(totalCount);
		// 总页数
		// private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		// 当前页要显示的数据
		// private List<Student> list;
		int index = (pageIndex - 1) * pageSize;
		List<Course> list = courseDao.pageBeanList(index, pageSize);
		pageBean.setList(list);

		return pageBean;
		
	}

	@Override
	public List<Course> findAll() {
		ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		   CourseDao courseDao = (CourseDao) applicationContext.getBean("courseDao");
		return courseDao.findAll();
	}

	@Override
	public PageBean<Course> pageBean(FindCourseByCondition findCourseByCondition) {
		PageBean<Course> pageBean = new PageBean<Course>();
		// 当前页
		// private Integer pageIndex;
		pageBean.setPageIndex(findCourseByCondition.getPageIndex());
		// 当前页显示的条数
		// private Integer pageSize;
		pageBean.setPageSize(findCourseByCondition.getPageSize());
		// 总条数
		// private Integer totalCount;
		int totalCount = courseDao.totalCountByCondition(findCourseByCondition);
		pageBean.setTotalCount(totalCount);
		// 总页数
		// private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / findCourseByCondition.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 当前页要显示的数据
		// private List<Student> list;
		int index = (findCourseByCondition.getPageIndex() - 1) * findCourseByCondition.getPageSize();
		Map<Object, Object> map = new HashMap<Object,Object>();
		map.put("findCourseByCondition", findCourseByCondition);
		map.put("index", index);
		List<Course> list = courseDao.pageBeanListByCondition(map);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void delete(int id) {
		courseDao.delete(id);
	}

	@Override
	public void add(String name, String credit) {
		courseDao.add(name,credit);
	}

	@Override
	public Course findById(int id) {
		 return courseDao.findById(id);
	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
	}

}

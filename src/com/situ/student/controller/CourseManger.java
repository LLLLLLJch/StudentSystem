package com.situ.student.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Course;
import com.situ.student.service.ICourseService;
import com.situ.student.vo.FindBanjiByName;
import com.situ.student.vo.FindCourseByCondition;
import com.situ.student.vo.PageBean;

@Controller
@RequestMapping(value="/course")
public class CourseManger {
	
	@Resource(name="courseService")
	private ICourseService courseService;
	
	private void findAll() {
		List<Course> list = courseService.findAll();
		
	}
	
	@RequestMapping(value="/pageBean")
	private String pageBean(String pageIndexStr,String pageSizeStr,Model model) {
		int pageIndex = 1;
		if(pageIndexStr != null && !pageIndexStr.equals("")){
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if(pageSizeStr != null && !pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Course> pageBean = courseService.pageBean(pageIndex,pageSize);
		model.addAttribute("pageBean",pageBean);
		return "course_list";
	}
	
	@RequestMapping(value="/findCourseByName")
	private String findCourseByName(HttpServletRequest req,Model model) {
		
		String name = req.getParameter("name");
		String credit = req.getParameter("credit");
		System.out.println(name);
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;
		if(pageIndexStr != null && !pageIndexStr.equals("")){
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if(pageSizeStr != null && !pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		FindCourseByCondition findCourseByCondition = new FindCourseByCondition(name,credit,pageIndex,pageSize);
		PageBean<Course> pageBean = courseService.pageBean(findCourseByCondition);
		model.addAttribute("pageBean", pageBean);
		return "course_list";
		
	}
	
	@RequestMapping(value="/deleteCourse")
	private String deleteCourse(int id) {
		courseService.delete(id);
		return "redirect:/course/findCourseByName.action";
		
	}

	@RequestMapping(value="/getAddPage")
	private String getAddPage() {
		return "course_add";
		
	}
	
	@RequestMapping(value="/add")
	private String add(String name,String credit) {
		courseService.add(name,credit);
		return "redirect:/course/findCourseByName.action";
		
	}
	
	@RequestMapping(value="/toUpdateCourse")
	private String toUpdateCourse(int id,Model model) {
		Course course = courseService.findById(id);
		model.addAttribute("course",course);
		return "course_update";
		
	}
	
	@RequestMapping(value="/update")
	private String update(Course course) {
		courseService.update(course);
		return "redirect:/course/findCourseByName.action";
		
	}
}

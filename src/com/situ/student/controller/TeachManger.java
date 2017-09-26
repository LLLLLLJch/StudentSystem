package com.situ.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.SearchStudent;
import com.situ.student.pojo.Student;
import com.situ.student.pojo.Teach;
import com.situ.student.service.ITeachService;
import com.situ.student.vo.PageBean;

@Controller
@RequestMapping(value="/teach")
public class TeachManger {

	@Resource(name="teachService")
	private ITeachService teachService;
	
	@RequestMapping(value="/teachIndex")
	public String teachIndex(Model model) {
		List<Banji> list = teachService.teach();
		model.addAttribute("list",list);
		return "education";
		
	}
	
	@RequestMapping(value="/getPageBean")
	private String getPageBean(Model model) {
		List<Banji> list1 = teachService.teach();
		List<Teach> list = teachService.pageBean(list1);
		model.addAttribute("list", list);
		return "education";
		
	}
	
	@RequestMapping(value="/teachSearch")
	public String teachSearch(Model model) {
		System.out.println("TeachManger.teachSearch()sdffffffffffffffffffffffffffffffffffffffffff");
		List<Student> list = teachService.findAll();
		model.addAttribute("list", list);
		return "teach";
	}
	
	@RequestMapping(value="/addCourse")
	public String addCourse(String banji,String addCourse) {
		System.out.println(banji+"dsssssssssssssssssssssssssssssssssssssssssssssss");
		System.out.println(addCourse);
		teachService.addCourse(Integer.parseInt(banji),Integer.parseInt(addCourse));
		return "redirect:/teach/getPageBean.action";
	}
	
	@RequestMapping(value="delCourse")
	public String delCourse(String banji,String delCourse) {
		teachService.delCourse(Integer.parseInt(banji),Integer.parseInt(delCourse));
		return "redirect:/teach/getPageBean.action";
	}
	
	
	@ResponseBody
	public List<Student> searchStudentInfo(String studentName) {
		List<Student> list = teachService.findByName(studentName);
		return list;
		
	}
	@RequestMapping("/searchStudentInfo")
	public String changeStudentInfo(String studentName,Model model) {
		System.out.println(studentName);
		List<Student> oldList = teachService.findByName(studentName);
		List<SearchStudent> list = teachService.changeStudentInfo(oldList);
		model.addAttribute("list", list);
		System.out.println(list+"-----------------");
		return "credit";
		
	}
}

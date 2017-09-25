package com.situ.student.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.student.exception.NameException;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Student;
import com.situ.student.service.IBanjiService;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.vo.FindByCondition;
import com.situ.student.vo.PageBean;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping(value = "/student")
public class StudentManger {
	@Resource(name = "studentService")
	private IStudentService studentService;
	@Resource(name = "banjiService")
	private IBanjiService banjiService;

	@RequestMapping(value = "/findAllStudent")
	public ModelAndView findAllStudent() {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> list = studentService.findAll();
		System.out.println("StudentManger.findAllStudent()");
		modelAndView.addObject("list", list);
		modelAndView.setViewName("student_list");
		return modelAndView;

	}

	@RequestMapping(value = "/getFindAll")
	public String getFindAll() {
		return "redirect:/student/pageBean.action";
	}

	@RequestMapping(value = "/getAddPage")
	public String getAddPage(Model model) {
		/*
		 * List<Banji> banji_list = banjiService.findAllBanji();
		 * model.addAttribute("banji_list",banji_list);
		 */
		return "student_add";
	}

	@RequestMapping(value = "/deleteStudent")
	public String deleteStudent(String id) {
		studentService.deleteStudent(Integer.parseInt(id));
		return "redirect:/student/findAllStudent.action";
	}

	@RequestMapping(value = "/toUpdateStudent")
	public String toUpdateStudent(String id, Model model) {
		Student student = studentService.findById(Integer.parseInt(id));
		model.addAttribute("student", student);
		System.out.println(student);
		return "student_update";
	}

	@RequestMapping(value = "/updateStudent")
	public String updateStudent(HttpServletRequest req) {
		// System.out.println(student);
		// service.updateStudent(student);
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String banji = req.getParameter("banji");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Banji banjiUpdate = new Banji(Integer.parseInt(banji));
		Student student = new Student(Integer.parseInt(id), name, Integer.parseInt(age), gender, address, date,
				banjiUpdate);
		studentService.updateStudent(student);
		return "redirect:/student/findAllStudent.action";
	}

	@RequestMapping(value = "/addStudents")
	public String addStudents(HttpServletRequest req) {
		/* service.addStudents(student); */
		String name = req.getParameter("name");
		System.out.println(name + "dsfffffffffffffffff");
		String age = req.getParameter("age");
		System.out.println(age);
		String gender = req.getParameter("gender");
		System.out.println(gender);
		String address = req.getParameter("address");
		System.out.println(address);
		String birthday = req.getParameter("birthday");
		System.out.println(birthday);
		String banji = req.getParameter("banji");
		System.out.println(banji);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Banji banjiAdd = new Banji(Integer.parseInt(banji));
		System.out.println(banjiAdd);
		Student student = new Student(name, Integer.parseInt(age), gender, address, date, banjiAdd);
		try {
			studentService.addStudents(student);
		} catch (NameException e) {
			e.printStackTrace();
		}
		return "redirect:/student/findCondition.action";
	}

	@RequestMapping(value = "/pageBean")
	public String pageBean(String pageIndexStr, String pageSizeStr, Model model) {
		System.out.println(studentService == null);
		System.out.println("******************************");
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Student> pageBean = studentService.getPageBean(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		System.out.println(pageBean);
		return "student_list";

	}

	@RequestMapping("/deleteAll")
	private String deleteAll(int[] selectIds) {
		studentService.deleteAll(selectIds);
		return "redirect:/student/pageBean.action";

	}

	@RequestMapping(value = "/findCondition")
	private String findCondition(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		FindByCondition condition = new FindByCondition(name, age, gender, pageIndex, pageSize);
		PageBean<Student> pageBean = studentService.findCondition(condition);
		System.out.println(pageBean + "dffffffffffffffffffff");
		model.addAttribute("pageBean", pageBean);
		return "student_list";

	}

	@RequestMapping(value = "/checkName")
	private @ResponseBody Map<String, Object> checkName(String name) throws IOException, ServletException {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isExist = false;
		if (studentService.checkName(name) == 0) {
			isExist = true;
		}
		map.put("isExist", isExist);
		return map;
	}
}

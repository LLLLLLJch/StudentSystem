package com.situ.student.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.student.pojo.Admit;
import com.situ.student.service.IAdmitService;
import com.situ.student.service.impl.AdmitServiceImpl;
@Controller
@RequestMapping(value="/login")
public class LoginManger {
	
	IAdmitService admitService = new AdmitServiceImpl();
	
	@RequestMapping(value="/getLoginPage")
	private String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/getLogin")
	private String login(HttpServletRequest request,String checkCode,HttpServletResponse response,String name,String password){
		System.out.println("sdfaaaaaaaaaaaa");
		String checkCodeSession = (String) request.getSession().getAttribute("checkCodeSession");
		System.out.println(checkCode);
		if (checkCode == null || checkCode.equals("")) {
			return "login";

		}
		if (!checkCode.equalsIgnoreCase(checkCodeSession)) {
			return "login";
		}
		Admit admit = admitService.findByNameAndPassword(name, password);
		if (admit != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admit", admit);
			System.out.println(admit);
			ServletContext servletContext = request.getServletContext();
			List<Admit> onlineAdmitList = (List<Admit>) servletContext.getAttribute("onlineAdmitList");
			onlineAdmitList.add(admit);
			  return "redirect:/student/findCondition.action";

		} else {
			System.out.println("LoginServlet.service()");
			System.out.println(name);
			System.out.println(password);
			return "fail";
		}
		
	}
}

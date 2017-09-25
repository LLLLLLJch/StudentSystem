package com.situ.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.student.pojo.Admit;

public class LogoutManger {

	@RequestMapping(value="logout")
	private String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null){
			Admit admit = (Admit) session.getAttribute("admit");
			session.invalidate();
		}
		return "login";
	}
	
}

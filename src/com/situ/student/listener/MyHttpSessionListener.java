package com.situ.student.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.situ.student.pojo.Admit;

public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession httpSession = se.getSession();
		ServletContext servletContext = httpSession.getServletContext();
		List<Admit> onlineAdmitList = (List<Admit>) servletContext.getAttribute("onlineAdmitList");
		Admit admit = (Admit) httpSession.getAttribute("admit");
		if(admit != null){
			onlineAdmitList.remove(admit);
		}
		
	}

}

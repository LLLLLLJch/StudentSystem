package com.situ.student.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.situ.student.pojo.Admit;

public class OnlineAdmitListListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Admit> onlineAdmitList = new ArrayList<Admit>();
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("onlineAdmitList", onlineAdmitList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}


}

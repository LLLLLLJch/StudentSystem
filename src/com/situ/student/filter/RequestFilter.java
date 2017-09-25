package com.situ.student.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admit;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Course;
import com.situ.student.service.IBanjiService;
import com.situ.student.service.ICourseService;
import com.situ.student.service.impl.BanjiServiceImpl;
import com.situ.student.service.impl.CourseServiceImpl;

public class RequestFilter implements Filter {
	/*@Resource(name="banjiService")
	private IBanjiService banjiService;*/
	IBanjiService banjiService = new BanjiServiceImpl();
	ICourseService courseService = new CourseServiceImpl();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*System.out.println("RequestFilter.init()");
		 ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		   IBanjiService banjiService = (IBanjiService) applicationContext.getBean("banjiService");
*/

	}

	@Override	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		  HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String uri = httpServletRequest.getRequestURI();
		System.out.println(uri);
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		if (requestPath.equals("login.jsp")|| requestPath.equals("fail.jsp")
				|| requestPath.equals("checkImg")
				|| requestPath.equals("getLoginPage.action")
				|| requestPath.equals("getLogin.action")) {
			// 直接放行
			chain.doFilter(request, response);
		} else {
			
			HttpSession session = httpServletRequest.getSession();
			Admit admit = (Admit) session.getAttribute("admit");
			if (admit == null) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login/getLoginPage.action");
				return;
			} else {
				
				List<Banji> banji_list = banjiService.findAllBanji();
				List<Course> course_list = courseService.findAll();
				httpServletRequest.setAttribute("banji_list", banji_list);
				httpServletRequest.setAttribute("course_list", course_list);
				chain.doFilter(request, response);
			}

		}

	}

	@Override
	public void destroy() {

	}

}

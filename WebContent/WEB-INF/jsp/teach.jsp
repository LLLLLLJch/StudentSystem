<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
    <thead>
       <tr>
           <th>id</th>
           <th>姓名</th>
           <th>班级</th>
           <th>课程</th>
           <th>删除</th>
           <th>修改</th>
       </tr>
    </thead>
    <tbody>
       <c:forEach items="${list}" var="stu">
           <c:forEach items="${stu.banji.courseList}" var="course">
               <tr>
                  <td>${stu.id}</td>
                  <td>${stu.name}</td>
                   <td>${stu.banji.name}</td>
                  <td>${course.name}</td>
                  <td><a
                      href="${pageContext.request.contextPath}/student/deletById.action?id=${stu.id}">删除</a></td>
                  <td><a
                      href="${pageContext.request.contextPath}/student?toUpdateStudent&id=${stu.id}">修改</a></td>
               </tr>
           </c:forEach>
       </c:forEach>
    </tbody>
</table>
	
</body>
</html>
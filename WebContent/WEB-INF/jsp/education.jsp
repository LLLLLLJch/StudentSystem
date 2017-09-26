<%@page import="java.util.List"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jqury/jquery-1.11.1.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
		<!--小屏幕导航按钮和logo-->
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="index.html" class="navbar-brand">教务管理系统</a>
		</div>
		<!--小屏幕导航按钮和logo-->
		<!--导航-->
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a
					href="${pageContext.request.contextPath}/student/pageList.action"><span
						class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;学生管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/banji/banjiPageList.action"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/course/coursePageList.action"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/banjiCourse/changeBanjiCourse.action"><span
						class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;教务管理</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a
					href="${pageContext.request.contextPath}/admit/admitList.action"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">在线人数 <span
						class="caret"></span></a>
				<li><a href="/studentManger/logout"><span
						class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
			</ul>
		</div>
		<!--导航-->

	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a
						href="${pageContext.request.contextPath}/banjiCourse/changeBanjiCourse.action"
						class="list-group-item active">教务管理</a> <a
						href="${pageContext.request.contextPath}/jsp/student_credit.jsp"
						class="list-group-item">教务查询</a>
				</div>
			</div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/banjiCourse/changeBanjiCourse.action">教务管理</a>
					</li>
					<li>
						<form action="${pageContext.request.contextPath}/teach/searchStudentInfo.action" method="post">
							<input type = "text" name="studentName"/>
							<input type = "submit" value="提交"/>
						</form>
					</li>
				</ul>
				<table
					class="align-center table  table-bordered table-hover table-condensed">
					<tr>
						<td>ID</td>
						<td>班级</td>
						<td>课程</td>
						<td>添加课程</td>
						<td>删除课程</td>
					</tr>
					<c:forEach items="${list}" var="list">

						<tr>
							<td q>${list.banjiId}</td>
							<td>${list.banjiName}</td>
							<td>
								${list.courseName}
							</td>
							<form
								action="${pageContext.request.contextPath}/teach/addCourse.action"
								method="post">
								<td>
									<input type="hidden" name="banji" value="${list.banjiId}" />
									<select name="addCourse" id = "addCourse" >
										<c:forEach items="${course_list}" var="course">
											<option value="${course.id}">${course.name}</option>
										</c:forEach>
								</select> <input  type="submit" value="确认" class="btn btn-default" /></td>
							</form>
							<form
								action="${pageContext.request.contextPath}/teach/delCourse.action"
								method="post">
								<td><input type="hidden" name="banji" value="${list.banjiId}" />
									<select name="delCourse">
										<c:forEach items="${course_list}" var="course">
											<option value="${course.id}">${course.name}</option>
										</c:forEach>
								</select> <input type="submit" value="确认" class="btn btn-default" /></td>
							</form>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<style>
.align-center {
	margin: 10px auto;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jqury/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#name")
				.blur(
						function() {
							var name = $("#name").val();
							$
									.post(
											"${pageContext.request.contextPath}/student?method=checkName", //url
											{
												"name" : name
											}, //data
											function(data) { //callback
												if (data.result) {
													$("#nameInfo").html(
															"课程不能为空");
													$("#nameInfo").css("color",
															"red");
												} else {
													if (data.isExist) {//用户已经存在
														$("#nameInfo").html(
																"该课程已存在");
														$("#nameInfo").css(
																"color", "red");
													} else {
														$("#nameInfo").html(
																"该课程可用");
														$("#nameInfo").css(
																"color",
																"green");
													}
												}
											}, "json" //type
									);
						});
	});
</script>
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
					href="${pageContext.request.contextPath}/student?method=pageList"><span
						class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;学生管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/banji?method=banjiPageList"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/course?method=coursePageList"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/banjiCourse?method=changeBanjiCourse"><span
						class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;教务管理</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="${pageContext.request.contextPath}/admit?method=admitList" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">在线人数 <span class="caret"></span></a>
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
						href="${pageContext.request.contextPath}/course?method=coursePageList"
						class="list-group-item" >课程管理</a> <a
						href="${pageContext.request.contextPath}/studentManger/jsp/course_add.jsp"
						class="list-group-item active">添加课程</a>
				</div>
			</div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li><a
						href="${pageContext.request.contextPath}/course?method=coursePageList">课程列表</a>
					</li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/studentManger/jsp/course_add.jsp">添加课程</a>
					</li>
				</ul>
				<form action="${pageContext.request.contextPath}/course/add.action"
					method="post">

					<div class="form-group">
						<label for="exampleInputEmail1">Name</label> <input type="text"
							class="form-control" placeholder="Name" name="name" id="name">
						<span id="nameInfo"></span>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Credit</label> <input type="text"
							class="form-control" name="credit" placeholder="credit">
					</div>
					<div>
						<input type="submit" class="btn btn-primary" value="提交" />
					</div>
				</form>
			</div>
</body>
</html>
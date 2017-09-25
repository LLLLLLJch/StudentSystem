<%@ page language="java" pageEncoding="utf-8"%>
<!--导航-->
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
				<li class="active"><a
					href="${pageContext.request.contextPath}/student/pageBean.action"><span
						class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;学生管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/banji/pageBean.action"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/course/pageBean.action"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/teach/getPageBean.action"><span
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
<!--导航-->
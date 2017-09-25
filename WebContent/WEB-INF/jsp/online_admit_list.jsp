<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.situ.student.pojo.*"%>
<%@page import="java.util.*"%>
<%@ page import="com.situ.student.vo.*"%>
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
<style>
.align-center {
	margin: 10px auto;
}
</style>
</head>
<body>
	<div style="width: 800px; margin: auto;">
		<table style="width: 800px;"
			class="align-center table  table-bordered table-hover table-condensed">
			<tr>
				<td>id</td>
				<td>姓名</td>
				<td>密码</td>
			</tr>
			<c:forEach items="${onlineAdmitList}" var="admit">
				<tr>
					<td>${admit.id}</td>
					<td>${admit.name}</td>
					<td>${admit.password}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
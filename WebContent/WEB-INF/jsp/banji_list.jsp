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
<script type="text/javascript">
function goPage(pageIndex) {
	$('#pageIndex').val(pageIndex);
	$('#searchForm').submit();
}
function delBanji(id){
	var isDel = confirm("你确定要删除吗？");
	if(isDel){
		location.href = "${pageContext.request.contextPath}/banji/deleteBanji.action?id="
				+id;
	}
}
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
					href="${pageContext.request.contextPath}/student/pageList.action"><span
						class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;学生管理</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/banji/banjiPageList.action"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/course/pageBean.action"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/education/getEducation.action"><span
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
						href="${pageContext.request.contextPath}/banji?method=banjiPageList"
						class="list-group-item active">班级管理</a> <a
						href="${pageContext.request.contextPath}/banji/getAddPage.action"
						class="list-group-item">添加班级</a>
				</div>
			</div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/banji?method=banjiPageList">班级列表</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/banji/getAddPage.action">添加班级</a>
					</li>
				</ul>
				<table class="align-center table  table-bordered table-hover table-condensed">
					<tr>
							<form id="searchForm"
								action="${pageContext.request.contextPath}/banji/findBanjiCondition.action"
								method="post">
								<input type="hidden" name="pageIndex" id="pageIndex" />
								<td colspan="3"><label for="exampleInputEmail1">name：</label><input
									type="text" name="name" value = "${banjiPageBean.name}"
									placeholder="班级名称" class="form-control" /></td>
								<td colspan="1"><input 
									style="margin-top: 25px; margin-left:15px;" type="submit"
									value="search" class="btn btn-success" /></td>
							</form>
						</tr>
					<tr>
						<td>编号</td>
						<td>班级名称</td>
						<td>删除</td>
						<td>修改</td>
					</tr>
					<tr>
						<c:forEach items="${pageBean.list}" var="banji">
							<tr>
								<td>${banji.id}</td>
								<td>${banji.name}</td>
								<td><a href="javascript:delBanji(${banji.id})">删除</a></td>
								<td><a
									href="${pageContext.request.contextPath }/banji/toUpdateBanji.action?id=${banji.id}">修改</a></td>
							</tr>
						</c:forEach>
					</tr>
				</table>
				<nav aria-label="Page navigation" style="float:right;">
					<ul class="pagination">
						<c:if test="${pageBean.pageIndex==1}">
							<li class="disabled"><a href="javascript:void(0);"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:if test="${pageBean.pageIndex!=1}">
							<li><a href="javascript:goPage(${pageBean.pageIndex-1})"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
							<c:if test="${pageBean.pageIndex!=page}">
								<li><a href="javascript:goPage('${page}')">${page}</a></li>
							</c:if>
							<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
							<c:if test="${pageBean.pageIndex==page}">
								<li class="active"><a href="javascript:goPage('${page}')">${page}</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${pageBean.pageIndex==pageBean.totalPage}">
							<li class="disabled"><a href="javascript:void(0);"
								aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
						<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
							<li><a href="javascript:goPage(${pageBean.pageIndex+1})"
								aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
					</nav>
			</div>
		</div>
	</div>
</body>
</html>
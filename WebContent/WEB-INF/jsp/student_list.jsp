<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	function delStudent(id) {
		var isDel = confirm("你确定要删除吗？");
		if (isDel) {
			location.href = "${pageContext.request.contextPath}/student/deleteStudent.action?id="
					+ id;
		}
	}
	function selectAll() {
		$("input[name = selectIds]").prop("checked",
				$("#selectAlls").is(":checked"));
	}

	function deleteAll() {
		$("#mainForm").submit();
	}

</script>
</head>
<body>
	<%@include file="common/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a
						href="${pageContext.request.contextPath}/student/pageBean.action"
						class="list-group-item active">学生管理</a> <a
						href="${pageContext.request.contextPath}/student/getAddPage.action"
						class="list-group-item">添加学生</a>
				</div>
			</div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/student/pageBean.action">学生列表</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/student/getAddPage.action">添加学生</a>
					</li>
				</ul>
				<div style="width: 800px; margin: auto;">

					<form id="searchForm"
						action="${pageContext.request.contextPath}/student/findCondition.action"
						method="post">


						<table style="width: 800px;"
							class="align-center table  table-bordered table-hover table-condensed">
							<tr>
								<input type="hidden" name="pageIndex" id="pageIndex" />
								<td colspan="3"><label for="exampleInputEmail1">name：</label><input
									type="text" name="name" value="${condition.name}"
									placeholder="姓名" class="form-control" /></td>
								<td colspan="2"><label for="exampleInputEmail1">age</label><input
									type="text" name="age" value="${condition.age}"
									placeholder="年龄" class="form-control" /></td>
								<td colspan="1"><label for="exampleInputEmail1">gender</label><select
									id="gender" name="gender" class="form-control">
										<option value="">不限</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select></td>
								<td colspan="1"><input
									style="margin-top: 25px; margin-left: 15px;" type="submit"
									value="search" class="btn btn-success" /></td>
							</tr>
						</table>
					</form>
					<form id="mainForm"
						action="${pageContext.request.contextPath}/student/deleteAll.action"
						method="post">
						<input type="submit" value="批量删除" onclick="deleteAll();" />
						<table style="width: 800px;"
							class="align-center table  table-bordered table-hover table-condensed">
							<tr>
								<td><input type="checkBox" id="selectAlls"
									onclick="selectAll();" /></td>
								<td style="width: 100px;">id</td>
								<td style="width: 100px;">姓名</td>
								<td style="width: 100px;">年龄</td>
								<td style="width: 100px;">性别</td>
								<td style="width: 100px;">地址</td>
								<td style="width: 100px;">出生日期</td>
								<td style="width: 100px;">班级</td>
								<td style="width: 100px;">删除</td>
								<td style="width: 100px;">修改</td>
							</tr>
							<c:forEach items="${pageBean.list}" var="student">
								<tr>
									<td><input type="checkBox" name="selectIds"
										value="${student.id}" /></td>
									<td>${student.id}</td>
									<td>${student.name}</td>
									<td>${student.age}</td>
									<td>${student.gender}</td>
									<td>${student.address}</td>
									<td><fmt:formatDate value="${student.birthday}"
											pattern="yyyy-MM-dd" /></td>
									<td>${student.banji.name}</td>
									<td><a href="javascript:delStudent(${student.id})">删除</a></td>
									<td><a
										href="${pageContext.request.contextPath }/student/toUpdateStudent.action?id=${student.id}">修改</a></td>
								</tr>
							</c:forEach>
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
</body>
</html>
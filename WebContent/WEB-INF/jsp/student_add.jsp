<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jqury/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jqury/jquery-form.js"></script>
<link
	href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<style>
.align-center {
	margin: 10px auto;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#name")
				.blur(
						function() {
							var name = $("#name").val();

							$
									.post(
											"${pageContext.request.contextPath}/student/checkName.action", //url
											{
												"name" : name
											}, //data
											function(data) { //callback
												alert(data);
												if (data.isExist) {
													$("#nameInfo")
															.html("用户名可用");
													$("#nameInfo").css("color",
															"green");
												} else {
													$("#nameInfo").html(
															"用户名已存在");
													$("#nameInfo").css("color",
															"red");
												}

											}, "json" //type 
									);
						});
	});
</script>
<script type="text/javascript">
function uploadPic() {
    //定义参数
    var options = {
        url:"${pageContext.request.contextPath}/upload/getUpload.action",
        dataType:"json",
        type:"post",
        success: function(data) {
        	alert(data.fileName);
            $("#picture").attr("src","/pic/" + data.fileName);
            $("#mainImage").val(data.fileName);
        }
    };
     $("#form-add").ajaxSubmit(options);
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
						href="${pageContext.request.contextPath}/student/findAllStudent.action"
						class="list-group-item">学生管理</a> <a
						href="${pageContext.request.contextPath}/student/getAddPage.action"
						class="list-group-item active">添加学生</a>
				</div>
			</div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li><a
						href="${pageContext.request.contextPath}/student/findAllStudent.action">学生列表</a>
					</li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/student/getAddPage.action">添加学生</a>
					</li>
				</ul>
				<form
					action="${pageContext.request.contextPath}/student/addStudents.action"
					method="post" enctype="multipart/form-data" id="form-add">

					<div class="form-group">
						<label for="exampleInputEmail1">Name</label> <input type="text"
							class="form-control" placeholder="Name" name="name" id="name">
						<span id="nameInfo"></span>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Age</label> <input type="text"
							class="form-control" name="age" placeholder="Age">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Gender</label> <input type="text"
							class="form-control" name="gender" placeholder="Gender">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Address</label> <input
							type="text" class="form-control" name="address"
							placeholder="Address">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Birthday</label> <input
							type="text" class="form-control" name="birthday"
							placeholder="Birthday">
					</div>
					<div class="form-group">
						<label for="addyonghuzu">所在班级</label> <select class="form-control"
							name="banji">
							<c:forEach items="${banji_list}" var="banji">
								<option value="${banji.id}">${banji.name}</option>
							</c:forEach>
						</select>
					</div>
						<div class="form-group">
							<label for="exampleInputEmail1">上传头像</label> <img alt="" src=""
								id="picture" width="100" height="100"> <input type="hidden" name="mainImage"
								id="mainImage" /> <input type="file" name="picUpload"
								onchange="uploadPic();"/>
						</div>
					<div>
						<input type="submit" class="btn btn-primary" value="提交"
							onclick="getAdd" />
					</div>
				</form>
			</div>
</body>
</html>
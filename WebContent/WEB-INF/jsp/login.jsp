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
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jqury/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function refreshImg(){
		/* document.getElementById("#refresh").src="${pageContext.request.contextPath}/checkImg?"+Math.random(); */
		$("#refresh").attr("src","${pageContext.request.contextPath}/checkImg?"+Math.random());
	}
 	
	 $(function() {
	       $("#checkCode").blur(function(){
	           var name = $("#checkCode").val();
	           $.post(
	               "${pageContext.request.contextPath}/login", //url
	               {"name":name}, //data
	               function(data) { //callback
	                  if(data.isExist) {
	                      $("#checkCodeInfo").html("验证码不能为空");
	                      $("#checkCodeInfo").css("color", "red");
	                  } 
	               },
	               "json" //type
	           );
	       });
	    });

</script>
</head>
<body>
	<div style="width: 300px; margin: auto;">
		<form action="${pageContext.request.contextPath}/login/getLogin.action" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Name:</label> <input
					type="text" class="form-control" name = "name"
					placeholder="Name">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name = "password"
					placeholder="Password">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id = "checkCode" name = "checkCode" placeholder="验证码">
				<span id = "checkCodeInfo"></span>
				<img id = "refresh" src="${pageContext.request.contextPath}/checkImg" onclick = "refreshImg();">
			</div>
			<div>
				<button type="submit" class="btn btn-primary">提交</button>
			</div>
		</form>
	</div>
</body>
</html>
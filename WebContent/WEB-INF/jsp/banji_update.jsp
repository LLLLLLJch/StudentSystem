<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
	<form action="${pageContext.request.contextPath}/banji/updateBanji.action"
		method="post">
		<div style="width: 300px; margin: auto;">
			<div style = "margin-top:10px;">
				<input type="text" name="id" value="${banji.id}"
					readonly="readonly" class="form-control" />
			</div>
			<div style = "margin-top:10px;">
				<input type="text" name="name" value="${banji.name}"
					class="form-control" />
			</div>
			<div style = "margin-top:10px; margin-left:120px;">
				<input type="submit" class="btn btn-info" value="修改" />
			</div>
		</div>
	</form>
</body>
</html>
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
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/student/updateStudent.action"
		method="post">
		<div style="width: 300px; margin: auto;">
			<div style="margin-top: 10px;">
				<input type="text" name="id" value="${student.id}"
					readonly="readonly" class="form-control" />
			</div>
			<div style="margin-top: 10px;">
				<input type="text" name="age" value="${student.age}"
					class="form-control" />
			</div>
			<div style="margin-top: 10px;">
				<input type="text" name="name" value="${student.name}"
					class="form-control" />
			</div>
			<div style="margin-top: 10px;">
				<input type="text" name="gender" value="${student.gender}"
					class="form-control" />
			</div>
			<div style="margin-top: 10px;">
				<input type="text" name="address" value="${student.address}"
					class="form-control" />
			</div>
			<div style="margin-top: 10px;">
				<input type="text" name="birthday" value="${student.birthday}"
					class="form-control" />
			</div>
			<div class="form-group">
				<select class="form-control" name="banji">
					<c:forEach items="${banji_list}" var="banji">
						<option value="${banji.id}">${banji.name}</option>
					</c:forEach>
				</select>
			</div>
			<div style="margin-top: 10px; margin-left: 120px;">
				<input type="submit" class="btn btn-info" value="修改" />
			</div>
		</div>
	</form>
</body>
</html>
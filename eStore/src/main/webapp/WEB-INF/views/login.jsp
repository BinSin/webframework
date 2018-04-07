<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container-wrapper">

		<h2>Login with username add password</h2>
		
		<c:if test="${not empty errorMsg}">
			<div style="color:#ff0000"> <h2> ${errorMsg} </h2> </div>
		</c:if>
		
		<c:if test="${not empty logoutMsg}">
			<div style="color:#0000ff"> <h2> ${logoutMsg} </h2> </div>
		</c:if>
		
		<form action="<c:url value="/login"/>" method="post">

			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter username"
					name="username" style="width: 50%">
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password" style="width: 50%">
			</div>

			<input type="submit" class="btn btn-primary"/>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

	</div>

</body>
</html>
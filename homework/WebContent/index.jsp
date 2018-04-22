<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<center>
	<h2>Login</h2>

	<form action="/homework1/doLogin" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td>: <input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>: <input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login In" /></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>
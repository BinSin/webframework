<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Page</title>
</head>
<body>
	<center>
		<h2>Reading All Request Parameters</h2>
		<table border="1">
			<tr align="center" >
				<td>Parameter Name</td>
				<td>Parameter Value(s)</td>
			</tr>
			<tr>
				<td>cardNum</td>
				<td align="left"><li><%= request.getParameter("cardNumber") %></li></td>
			</tr>
			<tr>
				<td>cardType</td>
				<td><%= request.getParameter("cardType") %></td>
			</tr>
			<tr>
				<td>price</td>
				<td><%= request.getParameter("price") %></td>
			</tr>
			<tr>
				<td>initial</td>
				<td><%= request.getParameter("initial") %></td>
			</tr>
			<tr>
				<td>itemNum</td>
				<td><%= request.getParameter("itemNumber") %></td>
			</tr>
			<tr>
				<td>address</td>
				<td><%= request.getParameter("address") %></td>
			</tr>
			<tr>
				<td>firstName</td>
				<td><%= request.getParameter("first") %></td>
			</tr>
			<tr>
				<td>description</td>
				<td><%= request.getParameter("description") %></td>
			</tr>
			<tr>
				<td>lastName</td>
				<td><%= request.getParameter("last") %></td>
			</tr>
		</table>
	</center>
</body>
</html>
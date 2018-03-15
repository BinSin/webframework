<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- css파일 적용  ( w3schools.com ) -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<!-- sf:() sf 사용  // modelAttribute => offer 객체의 name, email, text를 가져와서 반영한다.-->
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
	<!-- name을 동일하게 해야 바인딩이 제대로 이루어 진다. -->
		<table class="formtable">
			<tr> <td class="label">Name: </td> <td> <sf:input class="control" type="text" path="name" /> <br/>
			<sf:errors path="name" class="error" /> </td></tr>
			<tr> <td class="label">Email: </td> <td><sf:input class="control" type="text" path="email" /> <br/>
			<sf:errors path="email" class="error" /> </td> </tr>
			<tr> <td class="label">Offer: </td> <td><sf:textarea class="control" path="text" rows="10" cols="10" /> <br/>
			<sf:errors path="text" class="error" /> </td> </tr>
			<tr> <td class="label"> </td> <td class="control"> <input type="submit" value="새 개인" /> </td> </tr>
		</table>

	</sf:form>

</body>
</html>
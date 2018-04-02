<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container-wrapper">
	<div class="container">
		<h1>Update Product</h1>
		<p class="lead">Fill the below information to update a product:</p>
		
		<!-- spring form을 사용해서 각각의 필드에 매핑이 되어 들어간다. -->
		<!-- server의 내용을 spring form tag를 이용하여 client에 보여줄 수 있다. -->
		<sf:form action="${pageContext.request.contextPath}/admin/productInventory/updateProduct" 
			method="post" modelAttribute="product">
			
			<!-- 이것을 넣어야 product에 있는 id 값도 같이 나오게 된다. -->
			<sf:hidden path="id"/>
			
			<div class="form-group">
				<label for="name">Name</label>
				<sf:input path="name" id="name" class="form-control" />
				<sf:errors path="name" cssStyle="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="category">Category: </label>	
				<sf:radiobutton path="category" id="category" value="컴퓨터" /> 컴퓨터
				<sf:radiobutton path="category" id="category" value="가전" /> 가전
				<sf:radiobutton path="category" id="category" value="잡화" /> 잡화
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" id="description" class="form-control" />
			</div>
		
			<div class="form-group">
				<label for="price">Price</label>
				<sf:textarea path="price" id="price" class="form-control" />
				<sf:errors path="price" cssStyle="color:#ff0000;" />
			</div>
		
			<div class="form-group">
				<label for="unitInStock">UnitInStock</label>
				<sf:textarea path="unitInStock" id="unitInStock" class="form-control" />
				<sf:errors path="unitInStock" cssStyle="color:#ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="manufacture">Manufacture</label>
				<sf:textarea path="manufacture" id="manufacture" class="form-control" />
				<sf:errors path="manufacture" cssStyle="color:#ff0000;" />
			</div>
			
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
		
		</sf:form>
		<br />
	</div>
</div>
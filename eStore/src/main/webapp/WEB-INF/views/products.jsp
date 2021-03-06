<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=utf-8"%>

<div class="container-wrapper">
	<div class="container">
		<h2>All Products</h2>
		<p>착한 가격으로 상품을 살펴보세요~!</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary">
					<th>Photo Thumb</th>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Manufacture</th>
					<th>UnitInStock</th>
					<th>Description</th>
					<th>   </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td> <img src="<c:url value="/resources/images/${product.imageFilename}" />" alt="image" style="width:100%" /> </td>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacture}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
						<td><a href="<c:url value="/products/viewProduct/${product.id}"/>"><i class="fa fa-info-circle"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


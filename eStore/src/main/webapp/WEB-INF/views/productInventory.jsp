<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=utf-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>Product Inventory</h2>
		<p>제품 재고 현황입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary">
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Manufacture</th>
					<th>UnitInStock</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacture}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=utf-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>All Products</h2>
		<p>Here is the detail information of the product!</p>
		
		<c:set var="imageFilename" value="/resources/images/${product.id}.jpg" />
		
		<table>
			<tr>
				<th>
						<img src="<c:url value="${imageFilename}"/>" alt="image"
						style="width: 100%" />
				</th>
				<th width="50"></th>
				<th>
					${product.name}<br/>
					${product.description}<br/>
					<b>Manufacturer</b>:${product.unitInStock}<br/>
					<b>Category</b>:${product.category}<br/>
					${product.price}원
				</th>
			</tr>
		</table>
	</div>
</div>
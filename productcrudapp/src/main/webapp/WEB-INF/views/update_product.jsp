<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<title>update product</title>
</head>
<body>
	<div class="container mt-5">
		<h2>Update Product</h2>
		<form action="${pageContext.request.contextPath}/updatedProduct" method="POST">
			<div class="form-group">
				<label for="productId">Product ID</label> <input type="text"
					class="form-control" id="productId" name="id" required value="${product.id}" readonly>
			</div>
			<div class="form-group">
				<label for="productName">Product Name</label> <input type="text"
					class="form-control" id="productName" name="name" required value="${product.name}">
			</div>
			<div class="form-group">
				<label for="productDescription">Description</label>
				<textarea class="form-control" id="productDescription"
					name="description" rows="3" required>${product.description}</textarea>
			</div>
			<div class="form-group">
				<label for="productPrice">Price</label> <input type="number"
					class="form-control" id="productPrice" name="price" step="0.01"
					required  value="${product.price}"/>
			</div>
			<button type="submit" class="btn btn-warning">update Product</button>
			<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Back</a>
			
			<!-- Back button -->
		</form>
		
	</div>
</body>
</html>
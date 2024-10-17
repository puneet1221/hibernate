<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<title>${title}</title>
</head>
<body>
	<div class="container mt-5">
		<h2>Add New Product</h2>
		<form action="add-product" method="POST">
			<div class="form-group">
				<label for="productId">Product ID</label> <input type="text"
					class="form-control" id="productId" name="id" required>
			</div>
			<div class="form-group">
				<label for="productName">Product Name</label> <input type="text"
					class="form-control" id="productName" name="name" required>
			</div>
			<div class="form-group">
				<label for="productDescription">Description</label>
				<textarea class="form-control" id="productDescription"
					name="description" rows="3" required></textarea>
			</div>
			<div class="form-group">
				<label for="productPrice">Price</label> <input type="number"
					class="form-control" id="productPrice" name="price" step="0.01"
					required>
			</div>
			<button type="submit" class="btn btn-success">Add Product</button>
			<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Back</a>
			
			<!-- Back button -->
		</form>
		
	</div>
</body>
</html>
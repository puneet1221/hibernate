<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Home</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
		<a class="navbar-brand" href="#">Product CRUD App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="nav-item"><a
					class="nav-link bg-success text-white rounded "
					href="${pageContext.request.contextPath}/add-product">Add
						Product</a></li>
			</ul>
		</div>
	</nav>


	<div class="container mt-4">
		<h1 class="text-center">Product List</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>₹${product.price}</td>
						<td><div>

								<a
									href="${pageContext.request.contextPath}/update-product/${product.id}"><button
										class="btn-warning">Update</button></a> <a
									href="${pageContext.request.contextPath}/delete/${product.id}"><button
										class="btn-danger ml-5">Delete</button></a>
							</div></td>

					</tr>
				</c:forEach>
				<c:if test="${empty products}">
					<tr>
						<td colspan="4" class="text-center">No products available</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>

	<div class="container d-flex justify-content-center mt-4">
		<a href="${pageContext.request.contextPath}/delete-all"><button
				class="btn-danger ">Delete All</button></a>
	</div>

</body>
</html>

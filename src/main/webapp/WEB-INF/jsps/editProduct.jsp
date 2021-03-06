<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Edit Product</title>
</head>

<body>
	<div class="container-wrapper">
		<div class="container">
			<h1>Edit Product</h1>

			<form action="${pageContext.request.contextPath}/admin/product/editProduct" method="post">
				<input type="hidden" name="id" value="${product.id}"/> 
				
				<div class="form-group">
					<label for="name">Name</label>
					<input type="text" name="productName" value="${product.productName}"  />
				</div>

				<div class="form-group">
					<label for="category">Category</label> 
					 <label><input type="checkbox" name="productCategory" class="form-Control" value="herbs">Herbs</label> 
					 <label><input type="checkbox" name="productCategory" class="form-Control" value="flowers">Flowers</label> 
				</div>

				<div class="form-group">
					<label for="description">Description</label>
					<input type="text" name="productDescription" class="form-Control" value="${product.productDescription}" />
				</div>

				<div class="form-group">
					<label for="name">Price</label><form:errors path="price" cssStyle="color: #ff0000;"/> 
					<input type="text" name="productPrice" class="form-Control" value="${product.productPrice}"/>

				</div>

				<div class="form-group">
					<label for="status">Status</label> 
					 <label><input type="checkbox" name="productStatus" class="form-Control">active</label> 
					 <label><input type="checkbox" name="productStatus" class="form-Control">inactive</label> 
				</div>

				<div class="form-group">
					<label for="unitStock">Unit in Stock</label> 
					<input type="text" name="unitStock" class="form-Control" value="${product.unitStock}"/>				
				</div>

				<br></br>

				<input type="submit" value="update product" class="btn btn-default">
				<a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
			</form>
		</div>
	</div>
</body>
</html>


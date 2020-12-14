<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<%@include file="/WEB-INF/jsps/template/header.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<style><%@include file="/WEB-INF/css/home.css"%></style>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th>Product Thumbs</th>			
				<th>Product Name</th>
				<th>Category</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${products}" var="product">
		<tr>
			<td><img src="<c:url value="/ressources/images/${product.id}.png" />" alt="image" style="width:100%" /></td>
			<td>${product.productName}</td>
			<td>${product.productCategory}</td>
			<td>${product.productPrice} EUR</td>
			<td> <a href="<c:url value="/product/viewProduct/${product.id}"/>">infos</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
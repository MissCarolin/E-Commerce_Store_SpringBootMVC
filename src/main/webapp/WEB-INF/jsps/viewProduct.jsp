<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsps/template/header.jsp"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Details of Product</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="<c:url value="/ressources/images/${product.id}.png"/> "alt="image" style="width: 100%" />
			</div>
			<div class="col-md-5">
				<h3>${product.productName}</h3>
					<p>${product.productCategory}</p>
					<p>${product.productDescription}</p>
					<p>${product.productPrice} EUR</p>

					<br>
					<form action="${pageContext.request.contextPath}/customer/cart" method="post">
	
						<input type="hidden" name="id" value="${product.id}" /> 
						<input type="hidden" name="productName" value="${product.productName}" />
						<input type="hidden" name="productPrice" value="${product.productPrice}" /> 
						<a href="<spring:url value="#" />"class="btn btn-default">Add To Cart</a>
					</form>
		
					<a href="<spring:url value="/customer/cart" />"class="btn btn-default">View Cart</a>
				<a href="<spring:url value="/product/productList" />" class="btn btn-default">Back</a>
			</div>
		</div>
	</div>
</body>
</html>
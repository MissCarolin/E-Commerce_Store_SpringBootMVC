<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Happy Seeds</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a class="nav-link" href="<c:url value="/"/>">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li><a class="nav-link" href="<c:url value="/product/productList"/>">Products</a></li>
			
			<c:if test="${sessioncustomer.username != null}">
				<li><a class="nav-link" href="#"> Welcome: ${sessioncustomer.username}</a></li>
				<li><a class="nav-link" href="<c:url value="/logout" />">Logout</a></li>
				<li><a class="nav-link" href="<c:url value="/customer/cart" />">Cart</a></li>
			<c:if test="${sessioncustomer.username == 'admin'}">
				<li><a class="nav-link" href="<c:url value="/admin" />">Admin</a></li>
			</c:if>
			</c:if>
			<c:if test="${sessioncustomer.username  == null}">
				<li><a class="nav-link" href="<c:url value="/login/" />">Login</a></li>
				<li><a class="nav-link" href="<c:url value="/register" />">Register</a></li>
			</c:if>
		</ul>
		<form action="/filtered/category" method="post">
			<input type="hidden" name="productCategory" value="herbs" />
			<input type="submit" value="herbs" class="herbs"/></form>
		<form action="/filtered/category" method="post">
			<input type="hidden" name="productCategory" value="flowers" />
			<input type="submit" value="flowers" class="herbs"/></form>
		<form class="form-inline my-2 my-lg-0" action="/filtered/name" method="post">
			<input class="form-control mr-sm-2" type="text" placeholder="Search for a Seed" name="productName" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search by productName">Search</button>
		</form>
	</div>
	</nav>

	<!-- Bootstrap JS CSS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>

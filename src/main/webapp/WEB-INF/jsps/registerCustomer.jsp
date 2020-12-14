<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/template/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Register Customer</title>
</head>

<body>
	<div class="container-wrapper">
		<div class="container">
			<div id="login-box">
				<h1>Register Customer</h1>

				<form action="${pageContext.request.contextPath}/register"
					method="post">

					<h3>Basic Info</h3>

					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							name="customerName" id="name" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							name="customerEmail" id="email" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="phone">Phone</label> <input type="text"
							name="customerPhone" id="phone" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							name="username" id="username" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							name="password" id="password" class="form-Control" />
					</div>


					<h3>Billing Address</h3>

					<div class="form-group">
						<label for="billingStreet">Street Name</label> <input type="text"
							name="billingAddress.streetName" id="billingStreet"
							class="form-Control" />
					</div>

					<div class="form-group">
						<label for="billingApartmentNumber">Apartment Number</label> <input
							type="text" name="billingAddress.apartmentNumber"
							id="billingApartmentNumber" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="billingCity">City</label> <input type="text"
							name="billingAddress.city" id="billingCity" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="billingCountry">Country</label> <input type="text"
							name="billingAddress.country" id="billingCountry"
							class="form-Control" />
					</div>

					<div class="form-group">
						<label for="billingZip">Zipcode</label> <input type="text"
							name="billingAddress.zipCode" id="billingZip"
							class="form-Control" />
					</div>



					<h3>Shipping Address</h3>

					<div class="form-group">
						<label for="shippingStreet">Street Name</label> <input type="text"
							name="shippingAddress.streetName" id="shippingStreet"
							class="form-Control" />
					</div>

					<div class="form-group">
						<label for="shippingApartmentNumber">Apartment Number</label> <input
							type="text" name="shippingAddress.apartmentNumber"
							id="shippingApartmentNumber" class="form-Control" />
					</div>

					<div class="form-group">
						<label for="shippingCity">City</label> <input type="text"
							name="shippingAddress.city" id="shippingCity"
							class="form-Control" />
					</div>

					<div class="form-group">
						<label for="shippingCountry">Country</label> <input type="text"
							name="shippingAddress.country" id="shippingCountry"
							class="form-Control" />
					</div>

					<div class="form-group">
						<label for="shippingZip">Zipcode</label> <input type="text"
							name="shippingAddress.zipCode" id="shippingZip"
							class="form-Control" />
					</div>

					<br></br> <input type="submit" value="submit"
						class="btn btn-default"> <a href="<c:url value="/" />"
						class="btn btn-default">Cancel</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


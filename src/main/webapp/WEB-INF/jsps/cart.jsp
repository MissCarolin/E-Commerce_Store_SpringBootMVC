<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsps/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>

					<p>Your shopping cart</p>
				</div>
			</div>
		</section>

		<section class="container">
			<div>
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>1</td>
						<td>${product.productPrice}EUR</td>
						<td><a href="#" class="label label-danger">remove</a></td>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Total</th>
						<th></th>
						<th></th>
					</tr>
				</table>
				<a href="<spring:url value="/product/productList" />" class="btn btn-default">Continue Shopping</a>
			</div>
		</section>
	</div>
</div>

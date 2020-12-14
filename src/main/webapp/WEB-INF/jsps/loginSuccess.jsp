<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsps/template/header.jsp"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h3>Welcome ${sessioncustomer.username}, you successfully logged in</h3>
				</div>
			</div>
		</section>

		<section class="container">
			<p>

				<a href="<spring:url value="/product/productList" />"
					class="btn btn-default">Products</a>
			</p>
		</section>
	</div>
</div>

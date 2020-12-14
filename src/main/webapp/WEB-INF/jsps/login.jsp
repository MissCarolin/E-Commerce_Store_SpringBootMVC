<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/template/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container-wrapper">
		<div class="container">
			<div id="login-box">
				<h2>Login</h2>
				<br>
				<div style="color:red">${error}</div>
				<br>
				<form action="${pageContext.request.contextPath}/login"   method="post">
					<div class="form-group">
						<label for="username">User:</label>
						<input type="text" id="username" name="username" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input type="password" id="password" name="password" class="form-control"/>
					</div>		
					 <input type="submit" value="Submit" class="btn btn-default">					
				</form>
			</div>
		</div>
	</div>
</body>
</html>
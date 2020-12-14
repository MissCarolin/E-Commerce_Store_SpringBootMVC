<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/jsps/template/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	<div>
		<h1>Administrator Page</h1>
		<p>This is the administrator page</p>
	</div>
	
	<c:if test="${pageContext.request.userPrincipal.name !=null}">
          <h2>Welcome: ${pageContext.request.userPrincipal.name} 
            </h2>
            <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
    </c:if>
	
	<h3>
		<a href="<c:url value="/admin/productInventory" />" >Product Inventory</a>
	</h3>
	<p>view, check and modify the product inventory!</p>
	
	
</body>
</html>
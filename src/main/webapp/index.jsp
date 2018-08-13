<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Person Order System</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

	<div class="generic-container">
	<div class="well lead">Person information table</div>
			<span class="well floatRight">
				<a href="<c:url value='/addPerson' />">Add person</a>
			</span>
			<span class="well floatRight">
				<a href="<c:url value='/status' />">Show table</a>
			</span>
	</div>

</body>
</html>
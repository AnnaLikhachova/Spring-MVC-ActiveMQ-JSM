<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta charset="UTF-8" />
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		<div class="well floatRight">
			<div>
				<h2>Please fill in registration form</h2>
			</div>
			<div>
				<a href="<c:url value='/status' />">Status</a>
			</div>
		</div>
	</div>
	<div class="generic-container">
		<form action="addPerson" method="post">
			<div class="field">
				<label>Enter your name:</label>
				<div>
					<form:errors path="person.name" />
				</div>
				<div class="input">
					<input class="inputRL" type="text" name="name" value="" id="name" />
				</div>
			</div>
			<div class="field">
				<label>Enter your surname:</label>
				<div>
					<form:errors path="person.surname" />
				</div>
				<div class="input">
					<input class="inputRL" type="text" name="surname" value="" id="surname" />
				</div>
			</div>
			<div class="field">
				<div class="input">
					<input type="submit" class="btn btn-default" value="SEND"
						id="index" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>

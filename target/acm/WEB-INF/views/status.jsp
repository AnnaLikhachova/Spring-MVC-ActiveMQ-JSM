<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Order Status</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>

<script type="text/javascript">
function searchAjax() {
	$.ajax({
	    dataType : "json",
	    url : 'searchlostcard',
	    headers : {
	        'Accept' : 'application/json',
	        'Content-Type' : 'application/json'
	    },
	    type: 'POST',
	    data:$('#myform').serialize(),
	    success : function(responce) {   

	        $.each( responce,function(key, card) {
	            var htmlrow ="<tr><td>" + card.name + "</td></tr>";         
	            $('#persons').append(htmlrow);
	        }

	    },   
	    error : function(){
	        alert("error");
	    }
	});
	}

</script>
</head>

<body>
	<div id="g-container">
		<div class="well lead" id="results">Person Status</div>
		<table class="table table-hover table-striped" id="persons">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Surname</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${persons}" var="entry">
					<tr>
						<td>${entry.id}</td>
						<td>${entry.name}</td>
						<td>${entry.surname}</td>
						<td>
							<form action='status' method='post' name='person' id='myform'>
								<input type='hidden' name='id' value="${entry.id}" /><input
									type='submit' onclick='searchAjax()' id='send' name='delete'
									value='delete' />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<span class="well floatRight"> <a
			href="<c:url value='/addPerson' />">Add More</a>
		</span>
	</div>
</body>
</html>
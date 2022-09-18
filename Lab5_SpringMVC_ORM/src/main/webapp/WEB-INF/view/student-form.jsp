<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<title>Student Registration Form</title>
</head>
<body>
	<div class="container">
	<h3>Student Form</h3>
	<hr>
	
	<form action="/Lab5_SpringMVC_ORM/student/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}" />
			<br>
			<input type="text" name="name" value="${Student.name}" placeholder="Name"/>
			<br>
			<input type="text" name="department" value="${Student.department}" placeholder="Department">
			<br>
			<input type="text" name="country" value="${Student.country}" placeholder="country">
			<br>
			<br>
			<button type="submit">Save</button>
		</form>
		
		<hr>
		<a href="/Lab5_SpringMVC_ORM/student/list">Back to Students List</a>

	</div>
</body>
</html>
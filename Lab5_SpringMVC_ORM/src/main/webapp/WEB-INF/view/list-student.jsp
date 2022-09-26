<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	

<title>Student List</title>
</head>
<body>
	<div class="container">
		<h3>Students Directory</h3>
		<hr>
		<br>		
		<a href="/Lab5_SpringMVC_ORM/student/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Student</a>
		<br>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${Students}" var="tempStudent">
					<tr>
						<!-- <td><c:out value="${tempStudent.id}" /></td>  -->
						<td><c:out value="${tempStudent.name}" /></td>
						<td><c:out value="${tempStudent.department}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td>
							<!-- Add "update" button/link -->
							<a href="/Lab5_SpringMVC_ORM/student/showFormForUpdate?id=${tempStudent.id}" class="btn btn-success btn-sm"> Update </a>
							<!-- Add "delete" button/link -->
							<a href="/Lab5_SpringMVC_ORM/student/delete?id=${tempStudent.id}" class="btn btn-danger btn-sm" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>
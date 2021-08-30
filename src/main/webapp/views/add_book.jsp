<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="/" class="navbar-brand"> Book Management App </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form:form modelAttribute="new-book" action="/add-book" method="post">
					<caption>
						<h2>Add New Book</h2>
					</caption>
					<fieldset class="form-group">
						<label>Book's Name</label>
						<form:input type="text" class="form-control" path="name"
							required="required" />
					</fieldset>
					<fieldset class="form-group">
						<label>Book's Author </label>
						<form:input type="text" class="form-control" path="author" />
					</fieldset>
					<button type="submit" class="btn btn-success">Save</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
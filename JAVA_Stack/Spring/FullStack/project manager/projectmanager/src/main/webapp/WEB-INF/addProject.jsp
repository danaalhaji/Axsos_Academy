	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!-- c:out ; c:forEach etc. --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Formatting (dates) --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<!-- form:form -->
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- for rendering errors on PUT routes -->
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1> Hello ${logged.userName} </h1>
<div class="container-fluid d-flex justify-content-around" style="width: 70%; margin:0 auto;padding:20px;">
<form:form action="/project/submit" method="post" modelAttribute="newProject">
        <div class="form-group">
            <label>Title:</label>
            <form:input path="title" class="form-control" />
            <form:errors path="title" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Description:</label>
            <form:input path="desciption" class="form-control" />
            <form:errors path="desciption" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Due Date:</label>
            <form:input path="dueTo" class="form-control" type="date"/>
            <form:errors path="dueTo" class="text-danger" />
        </div>
        <input type="submit" value="Add Project" class="btn btn-primary" />
    </form:form>
</div>
</body>
</html>
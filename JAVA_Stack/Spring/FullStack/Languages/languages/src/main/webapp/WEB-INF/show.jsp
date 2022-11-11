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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container d-flex justify-content-between">
<div class=" bg-info bg-opacity-10 border border-info border-start-0 rounded-end" style="margin: 0 auto; width:50%; margin-top:10%; text-align: center;">
<p class="text-white">Name: ${lang.name}</p>
<p class="text-white">Creator: ${lang.creator}</p>
<p class="text-white">Current Version: ${lang.currentVersion}</p>
<p style="margin-top:10px;"><a href="/language/${lang.id}/delete">Delete</a></p>
<p><a href="/language/${lang.id}/edit">Edit</a></p>
</div>
<p><a href="/language">Back To Dashboard</a></p>
</div>
</body>
</html>
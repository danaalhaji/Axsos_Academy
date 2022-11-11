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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Insert title here</title>
<body>
<div class="container" style="width:50%; margin:0 auto; margin-top:50px;">
<h1 class="text-center text-danger">Add A Song</h1>
<div class="">
<form:form action="/book/submitnew" method="post" modelAttribute="newSong">
        <div class="form-group">
            <label>Title:</label>
            <form:input path="title" class="form-control border-success" id="exampleFormControlInput1" style="width:50%;" />
            <form:errors path="title" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Singer:</label>
            <form:input path="singer" class="form-control border-success" id="exampleFormControlInput1" style="width:50%;" />
            <form:errors path="singer" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Rating (1-10):</label>
    		<form:input path="rating" class="form-control border-success" style="width:50%;"/>
    		<form:errors path="rating" class="text-danger" />
  		</div>
        <input type="submit" value="Add A Song" class="btn btn-outline-danger" />
    </form:form>
    </div>
</div>
</body>
</html>
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
</head>
<body>
<div class="container align-items-center" style="margin: 0 auto; width:70%;">
<h1 class="display-6 text-danger">Top 10 Songs</h1>
<div style="margin:0 auto;margin-top:30px;">
<table class="table">
  <thead class="table-danger">
      <tr>
      <th scope="col">Title</th>
      <th scope="col">Singer</th>
      <th scope="col">Rating</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="s" items="${songss}">
    <tr>
      <td>${s.title}</td>
      <td>${s.singer}</td>
      <td>${s.rating}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>
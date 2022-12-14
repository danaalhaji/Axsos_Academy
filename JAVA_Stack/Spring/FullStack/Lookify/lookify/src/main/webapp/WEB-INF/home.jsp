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
<div>
<div class="d-flex justify-content-around" style="margin-top:50px;">
<a href="/song/new">Add New</a> <a href="/top10">Top Ten</a> 
<form class="d-flex justify-content-around" action="/search/song">
<label for="exampleDataList" class="form-label">Search by your favorite singer</label>
<input class="form-control" id="exampleDataList" placeholder="Type to search..." name="search">
 <button type="submit" class="btn btn-primary mb-3">Search</button>
</form>
</div>
<table class="table" style="margin-top:50px;">
  <thead class="table-danger">
      <tr>
      <th scope="col">Title</th>
      <th scope="col">Singer</th>
      <th scope="col">Rating</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="song" items="${songs}">
    <tr>
      <td>${song.title}</td>
      <td>${song.singer}</td>
      <td>${song.rating}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>
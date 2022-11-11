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
<style>
.link-button { 
     background: none;
     border: none;
     color: #1a0dab;
     text-decoration: underline;
     cursor: pointer; 
}
</style>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Book Club</title>
<title>welcome page</title>
</head>
<body>
<h1 class="display-4 text-info" style="margin:0 auto;">Welcome ${logged.userName}</h1>
<div class="container d-flex justify-content-evenly" style="margin:0 auto;padding:20px;">
<p>Books from everyone's shelves:</p> <p> <a href="/book/add">+ Add a book to my shelf!</a></p>
</div>
<table class="table" style="width:50%;margin:0 auto;">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted By</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}">
  <c:if test="${book.user_borower.id!=logged.id}">
    <tr>
      <td><a href="/book/${book.id}">${book.id}</a></td>
      <td>${book.title}</td>
      <td>${book.auther}</td>
      <td>${book.user.userName}</td>
      <c:if test="${book.user.id==logged.id}"><td><a href="/book/${book.id}/edit">Edit</a> | <a href="/book/${book.id}/delete">Delete</a>
      </td>
      </c:if>
       <c:if test="${book.user.id!=logged.id}">
       <td>
       <form:form action="/book/${book.id}/borrow" method="post" modelAttribute="book">
      <form:input  type="hidden" path="user_borower" class="form-control" />
       <input type="hidden" name="_method" value="put">
       <input type="submit"  value="Borrow" class="link-button" />
       </form:form>
       </td>
      </c:if>
    </tr>
    </c:if>
    </c:forEach>
  </tbody>
</table>
<h2 class="display-6 text-info" style="margin:0 auto;">Books You Borrowed</h2>
<table class="table" style="width:50%;margin:0 auto;">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted By</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
<c:forEach var="book" items="${books}">
  <c:if test="${book.user_borower != null}">
    <tr>
      <td><a href="/book/${book.id}">${book.id}</a></td>
      <td>${book.title}</td>
      <td>${book.auther}</td>
      <td>${book.user.userName}</td>
      <td>
      <form:form action="/book/${book.id}/unborrow" method="post" modelAttribute="book">
      <form:input  type="hidden" path="user_borower" class="form-control" />
       <input type="hidden" name="_method" value="delete">
       <input type="submit" value="Un-Borrow" class="link-button" />
       </form:form>
      </td>
      </tr>
      </c:if>
</c:forEach>
</table>
</body>
</html>
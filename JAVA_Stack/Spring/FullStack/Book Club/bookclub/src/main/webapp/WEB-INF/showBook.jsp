<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<title>Show Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container " style="width: 50%; margin:0 auto;padding:10px;">
<h1>${book.title}</h1>
<p>Author : ${book.auther} </p>
<p>Posted By: ${book.user.userName}</p>

  <c:if test="${book.user.userName==logged.userName}"><p class="fw-bold"><span class="text-info">You</span> read <span class="text-danger">${book.title}</span>
  by <span class="text-success">${book.auther}</span></p>
  <p class="fw-bold">Here are What you think !</p>
  <p>${book.description}</p></c:if>
    <c:if test="${book.user.userName!=logged.userName}"><p class="fw-bold"><span class="text-info">${book.user.userName}</span> read <span class="text-danger">${book.title}</span>
  by <span class="text-success">${book.auther}</span></p>
  <p class="fw-bold">Here is What ${book.user.userName} think !</p>
  <p>${book.description}</p></c:if>
  <c:if test="${book.user.id==logged.id}">
  <p>
          <a href="/book/${book.id}/edit">
            <button class="btn btn-primary ">Edit</button>
        </a>
                <a href="/book/${book.id}/delete">
            <button class="btn btn-danger ">Delete</button>
        </a>
        </p>
    </c:if>
</div>
</body>
</html>
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
<div class="container" style="width: 70%; margin:0 auto; padding:50px;">
<div class="d-flex justify-content-between">
<h1 class="display-4 text-info"><svg xmlns="http://www.w3.org/2000/svg text-info" width="35" height="35" fill="currentColor" class="bi bi-envelope-heart" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l3.235 1.94a2.76 2.76 0 0 0-.233 1.027L1 5.384v5.721l3.453-2.124c.146.277.329.556.55.835l-3.97 2.443A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741l-3.968-2.442c.22-.28.403-.56.55-.836L15 11.105V5.383l-3.002 1.801a2.76 2.76 0 0 0-.233-1.026L15 4.217V4a1 1 0 0 0-1-1H2Zm6 2.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
</svg>Edit ${editLang.name}  !</h1>
<p style="margin-top:10px;"><a href="/language/${lang.id}/delete">Delete</a>  |    <a href="/language">Back To Dashboard</a></p>
</div>
<div style = "width: 70%; margin: 0 auto;">
<form:form action="/language/edit/${editLang.id}" method="post" modelAttribute="editLang">
	<input type="hidden" name="_method" value="put">
        <div class="form-group">
            <label>Name:</label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Creator:</label>
            <form:input path="creator" class="form-control" />
            <form:errors path="creator" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Current Version:</label>
            <form:input path="currentVersion" class="form-control" />
            <form:errors path="currentVersion" class="text-danger" />
        </div>
        <input type="submit" value="Update Language" class="btn btn-primary" />
    </form:form>
</div>
</div>
</body>
</html>
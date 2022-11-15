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
<h1>${project.title}</h1>
<h2 class="text-white">Title</h2><p class="text-white"> ${project.title}</p>
<h2 class="text-white">Description:</h2><p class="text-white"> ${project.desciption}</p>
<h2 class="text-white">Team Lead:</h2>
<p class="text-white"> ${project.projectAdmin.userName}</p>
<p class="text-white">Due to Date: ${project.dueTo}</p>
<div style="margin: 0 auto;">
<form:form action="/task/${project.id}/submit" method="post" modelAttribute="newTask">
        <div class="form-group">
            <label>Submit Task to the team:</label>
            <form:input path="name" class="form-control" Style="width:200px; hieght:200px; margin: 0 auto;"/>
            <form:errors path="name" class="text-danger" />
            <input type="submit"  value="Add Task" class="btn btn-primary" />
        </div>
 </form:form>
 </div>
 <c:forEach var="task" items="${tasks}">
 	<h3 class="text-white display-6">Added by ${task.creator.userName} Added on ${task.createdAt} </h3>
 	<p class="text-white"> ${task.name}</p>
 </c:forEach>

</div>
<p><a href="/home">Back To Dashboard</a></p>
</div>
</body>
</html>
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
<title>welcome page</title>
</head>
<body>
<h1 class="display-4 text-info" style="margin:0 auto;">Welcome ${logged.userName}</h1>
<p><a href="/logout">Log out</a></p>

<div class="container d-flex justify-content-evenly" style="margin:0 auto;padding:40px;">
<p>><a href="/project/add">
            <button class="btn btn-primary btn-lg">+ Add a project</button>
        </a>
 </p>
</div>
<h2>All Projects!</h2>
<table class="table" style="width:50%;margin:0 auto;">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${projects}">
  <c:if test="${project.projectAdmin.id != logged.id }">
    <tr>
      <td><a href="/project/${project.id}">${project.title}</a></td>
      <td>${project.projectAdmin.userName}</td>
      <td>${project.dueTo}</td>
       <td>
       <a href="/project/${project.id}/join">join</a>
       </td>
       </tr>
       </c:if>
    </c:forEach>
  </tbody>
</table>

<h2 class="display-6 text-info" style="margin:0 auto;">Your Projects</h2>
<table class="table" style="width:50%;margin:0 auto;">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${myProjects}">
    <tr>
      <td><a href="/project/${project.id}">${project.title}</a></td>
      <td>${project.projectAdmin.userName}</td>
      <td>${project.dueTo}</td>
       <c:if test="${project.projectAdmin.id==logged.id}">
		<td>
		<a href="project/edit/${project.id }">Edit</a>
		</td>
		</c:if>
		<c:if test="${project.projectAdmin.id!= logged.id}">
		<td> <a href="/project/${project.id}/leave">Leave Team</a></td>
		</c:if>
       </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
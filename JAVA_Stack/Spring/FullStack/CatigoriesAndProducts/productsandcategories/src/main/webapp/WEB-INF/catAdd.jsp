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
<title>Insert title here</title>
</head>
<body>
<h1>New Category</h1>
<table>
<tr><td>Name</td><td><form:form action="/cat/create" method="post" modelAttribute="categorey">

        <form:label path="name"></form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
</td></tr>
<tr>        <input type="submit" value="Add Categorey"/>
</form:form>  </tr>
</table>
</body>
</html>
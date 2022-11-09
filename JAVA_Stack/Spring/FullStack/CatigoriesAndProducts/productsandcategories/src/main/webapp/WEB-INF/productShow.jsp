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
<h1> ${product.name}</h1>
<h2>Categories for this item</h2>
<c:forEach var="cat" items="${product.categories}">
<p> ${cat.name} </p>
</c:forEach>
<h2>Choose Category</h2>
<ul>
<c:forEach var="cate" items="${categorey}">
<li> ${cate.name} </li>
</c:forEach>
</ul>
<form action="/products/addcat" method="post" modelAttribute="product">
<input type="hidden" name ="product" value=${product.id}>
    	<select name="categories">
    	<c:forEach var="cate" items="${cat}">
    		<option value="${cate.id}">
    			<c:out  value="${cate.name}"/>
    		</option>
    		</c:forEach>
    	<select>
        <input type="submit" value="Add categories"/>
</form>
</body>
</html>
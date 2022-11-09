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
<h1> ${cate.name}</h1>
<h2>Products for this item</h2>
<c:forEach var="pro" items="${cate.products}">
<p> ${pro.name} </p>
</c:forEach>
<h2>Choose Products</h2>

<form action="/category/addcat" method="post" modelAttribute="category">
<input type="hidden" name ="category" value=${category.id}>
    	<select name="products">
    	<c:forEach var="product" items="${product}">
    		<option value="${product.id}">
    			<c:out  value="${product.name}"/>
    		</option>
    		</c:forEach>
    	<select>
        <input type="submit" value="Add product"/>
</form>
</body>
</html>
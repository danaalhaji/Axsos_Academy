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
<h1 style="margin= o auto;">Home Page</h1>
<p><a href="/categorey/add"> Add Category</a></p>
 <p>  <a href="/product/add"> Add Product</a></p>
 
 <table>
 <tr> <td>Products</td>  <td>Category</td></tr>
 <tr> <td><ul>
 <c:forEach var="product" items="${products}">
 <a href="/product/${product.id}"><li>
 <c:out  value="${product.name}"/>
  </li></a>
 </c:forEach>
</ul></td>
 <td><ul>
 <c:forEach var="category" items="${categories}">
 <a href="/category/${category.id}">
  <li>
 <c:out  value="${category.name}"/>
  </li></a>
 </c:forEach>
</ul></td></tr>
 </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${travel.expenses}</h1>
<p>Description for ${travel.expenses} : ${travel.description} </p>
<p>Language : ${travel.vendor} </p>
<p>${travel.amount}</p>
</body>
</html>
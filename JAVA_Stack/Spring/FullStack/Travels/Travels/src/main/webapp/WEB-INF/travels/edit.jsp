<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>    
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<form:form action="/travels/${travel.id}" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put">
   <p>
        <form:label path="expenses">expenses</form:label>
        <form:errors path="expenses"/>
        <form:input path="expenses"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="amount" path="amount"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
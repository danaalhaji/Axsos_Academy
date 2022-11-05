<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/app.js"></script>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
    crossorigin="anonymous"></script>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form  class="w-50 mx-auto" action='/submit' method='GET'>
<h1>Send an Omikuji</h1>

 <div class="form-group mt-3">
<label>Pick any number for from 5 to 25</label>
<input type="text"  name="num" min=5 max =25>
</div>

 <div class="form-group mt-3">
<label>Enter any name of a city</label>
<input type="text"  name="cityame">
</div>

 <div class="form-group mt-3">
<label>Enter the name of any person</label>
<input type="text"  name="pame">
</div>

 <div class="form-group mt-3">
<label>Enter professional endeavor or hobby</label>
<input type="text"  name="profname">
</div>

 <div class="form-group mt-3">
<label>Enter type of living thing</label>
<input type="text"  name="thingname">
</div>

 <div class="form-group mt-3">
<label>Enter type of living thing</label>
<textarea name="message" style="width:200px; height:200px;">
</textarea>
</div>


<p>send and show a friend</p>

  	<label for="exampleFormControlTextarea1" class="mt-2">Send and show a friend</label><br>
    <button type="submit" class="btn btn-primary mb-2 mt-4">Send</button>
    
</form>
</body>
</html>
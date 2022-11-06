<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Gold Ninja</title>
</head>
<body>
    <div class="container">
        <nav style="margin-top:20px; font-size: 1.5rem; color:rgb(165, 110, 42);margin-left: 50px;">
            Your Gold <label type="text"  style="color: rgb(230, 197, 13); border: 2px solid black; width: 15%;">${total}</label>
        </nav>
        <!-- Buttons Design -->
        <div class="row" style="margin: 50px;" >
            <!-- First Button -->
            <form  action='form' method='post' class="col bg-warning text-white d-grid gap-3" style="--bs-text-opacity: .8; margin-right: 2px;">
                <input name="formType" type="hidden" value="form" />
                <h2>
                    Form
                </h2>
                <p>
                    (earns 10-20 gold)
                </p>
                <button type="submit" class="shadow p-3 mb-5 rounded" name="Find1Gold">Find Gold!</button>
            </form>

            <!-- Second Button -->
            <form action='form' method='post' class="col bg-warning text-white d-grid gap-3" style="--bs-text-opacity: .8;margin-right: 2px;">
                <input name="formType" type="hidden" value="cave" />
                <h2>
                    Cave
                </h2>
                <p>
                    (earns 10-20 gold)
                </p>
                <button type="submit" class="shadow p-3 mb-5 rounded" name="Find2Gold">Find Gold!</button>
            </form>
            <!-- Third Button -->
            <form action='form' method='post' class="col bg-warning text-white d-grid gap-3" style="--bs-text-opacity: .8;margin-right: 2px;" >
                <input name="formType" type="hidden" value="house" />
                <h2>
                    House
                </h2>
                <p>
                    (earns 10-20 gold)
                </p>
                <button type="submit" class="shadow p-3 mb-5 rounded" name="Find3Gold">Find Gold!</button>
            </form>
            <!-- Fourth Button -->
            <form action='form' method='post' class="col bg-warning text-white d-grid gap-3" style="--bs-text-opacity: .8;">
                <input name="formType" type="hidden" value="quest" />
                <h2>
                    Quest
                </h2>
                <p>
                    (earns/takes 0-50 gold)
                </p>
                <button type="submit" class="shadow p-3 mb-5 rounded" name="Find4Gold">Find Gold!</button>
            </form>
        </div>
        <!-- Activity Tab -->
        <div style="margin-left: 50px;">
            <h2 style="color:rgb(66, 60, 60) ;">Activity:</h2>
           <label type="text" name="activity-game" style="width: 45%; color:blue;font-size: 1.1rem;overflow: scroll;height: 300px;">
        <c:forEach var="active" items="${active}">
        	<p><c:out value="${active}"></c:out></p>
    	</c:forEach>
            </label> 
        </div>
    </div>
</body>
</html>
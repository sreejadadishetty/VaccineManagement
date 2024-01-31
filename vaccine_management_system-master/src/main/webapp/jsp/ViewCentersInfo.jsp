<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Centers</title>
</head>
<style>
    #heading{
    height: 100px;
    background: rgb(0, 26, 255);
    line-height: 50px;
    text-align: center;
    color: rgb(39, 206, 42);
    }
    body{
        background-color: beige;
    }
   </style>
<body>
    <h1 id="heading"> Vaccine Management Tool</h1>

    <h3>Available Covaxin</h3>
    <core:forEach items="${l1}" var="covaxin1">
    ${covaxin1}
    </br>
    </core:forEach>

    <h3>Available Covishield</h3>

    <core:forEach items="${l2}" var="covishield1">
    ${covishield1}
    </br>
    </core:forEach>



</body>
</html>
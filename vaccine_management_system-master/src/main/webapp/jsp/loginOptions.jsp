<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<style>
    #heading{
    height: 100px;
    background: rgb(0, 26, 255);
    line-height: 50px;
    text-align: center;
    color: rgb(39, 206, 42);
    }
    #operations{
        background-color: bisque;
        color: crimson;
        text-align: center;
        height: 300px;
        font-style: italic;
        font-size: larger;
    }
    body{
        background-color: beige;
    }
    
</style>
<body>
    <h1 id="heading"> Vaccine Management Tool</h1>
    <br>
    <br>
    <div id="operations">
        <a href="/BookFirstDose">BookFirstDose</a>
        </br>
        <a href="/BookSecondDose">BookSecondDose</a>
        </br>
        <a href="/ViewCentersInfo">ViewCentersInfo</a>
        </br>
        <a href="/UserDashboard">ViewDashBoard</a>
    </div>
   </br>
</body>
</html>
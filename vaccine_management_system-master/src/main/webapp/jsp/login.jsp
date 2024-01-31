<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
    .error{
    color:red;
    font-style:italic;
    font-weight:bold;
    }
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
  #head{
    text-align: center;
    color: red;
  }
  table{
    border: 2px solid;
    color: blueviolet;
    align-items: center;
    margin-top: 5%;
    margin-left:33%;

  }
  body{
    align-items: center;
  }

</style>
</head>
<body>
    <h1 id="heading">Vaccine Management Tool</h1>
    <h3 id="head">Login</h3>
    <h2 style="color: red;">${message}</h2>
    <table>
        <form:form action="/login" method="post" modelAttribute="userModel">
       <tr>
                 <td><label for="aadhaar">Aadhaar</label> </td>
                 <td><input type="text" name="aadharNumber" ></td>
                 <td><form:errors path="aadharNumber" cssClass="error"></form:errors></td>
        </tr>
        <tr>
                  <td><label for="Password">Password</label> </td>
                  <td><input type="password" name="password" ></td>
                  <td><form:errors path="password" cssClass="error"></form:errors></td>
        </tr>
        <tr>
            <td colspan="1">
                <input type="submit">
            </td>
        </tr>
    </form:form>
      </table>
</body>
</html>
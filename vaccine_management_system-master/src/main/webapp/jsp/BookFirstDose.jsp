<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
    <h3 id="head">Book First Dose</h3>
<table>
        <form:form action="/BookFirstDose" method="post" modelAttribute="userModel">
        <tr>
        <td><label for="cars">Choose a center:</label></td>
        <td><select name="firstDoseCenterName" id="cars">
          <option value="Guntur">Guntur</option>
          <option value="Hyderabad">Hyderabad</option>
        </select>
        </td>
        <td><form:errors path="firstDoseCenterName" cssClass="error"></form:errors></td>

        </tr>
        <tr>
            <td><label for="cars">Choose a Vaccine:</label></td>
            <td><select name="vaccineName" id="cars">
            <option value="Covaxin">Covaxin</option>
            <option value="Covishield">Covishield</option>
            </select>
            </td>
            <td><form:errors path="vaccineName" cssClass="error"></form:errors></td>
        </tr>
        <td><label for="vaccineDate">First Dose Date</label></td>
        <td><input type="date" name="firstDoseDate"></td>
        <td><form:errors path="firstDoseDate" cssClass="error"></form:errors></td>

        <tr>
            <td colspan="1">
                <input type="submit">
            </td>
        </tr>
    </form:form>
      </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>  
<head>
<style>  
table, th, td {  
    border: 2px solid;
    color: blueviolet;
    align-items: center;
    
    margin-left:41%; 
    text-align: center;
    
}  
th, td {
    padding: 10px;
}
body{
        background-color: beige;
  }
#heading{
  height: 100px;
  background: rgb(0, 26, 255);
  line-height: 50px;
  text-align: center;
  color: rgb(39, 206, 42);
}

</style>  
</head>
<body>  
    <h1 id="heading">Vaccine Management Tool</h1> 
    <table>  
    <caption>User Dashboard</caption>  
    <tr><th>Attribut Name</th><th>Values</th></tr>  
    <tr><td>Name</td><td>${model.userName}</td></tr>  
    <tr><td>Age</td><td>${model.age}</td></tr>  
    <tr><td>Aadhaar Number</td><td>${model.aadharNumber}</td></tr>  
    <tr><td>Vaccine Name</td><td>${model.vaccineName}</td></tr>  
    <tr><td>First Dose Date</td><td>${model.firstDoseDate}</td></tr>
    <tr><td>Second Dose Date</td><td>${model.secondDoseDate}</td></tr>
    <tr><td>First Dose Center</td><td>${model.firstDoseCenterName}</td></tr>
    <tr><td>Second Dose Center</td><td>${model.secondDoseCenterName}</td></tr>
    </table>  
</body>
</html>  

 

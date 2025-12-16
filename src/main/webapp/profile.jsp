<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored ="false"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="header.html" %>
</head>
<body>
  <h3>Welcome To Customer Profile </h3>
  <table>
    <tr><td>Name</td><td>${customer.name}</td></tr>
    <tr><td>Email</td><td>${customer.email}</td></tr>
    <tr><td>Contact</td><td>${customer.contact}</td></tr>
    <tr><td>User Name</td><td>${customer.userName}</td></tr>
    <tr><td>Password</td><td>${customer.password}</td></tr>
    <tr><td>Address</td><td>${customer.address}</td></tr>
  </table><br>
  <a href="logout">Logout</a>
<%@include file="footer.html" %> 
</body>
</html>
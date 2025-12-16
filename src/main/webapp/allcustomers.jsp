<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="header.html" %>
</head>
<body>
  <h3>Welcome To All Customer Details</h3>
  <table align="center" border=1>
    <tr><td>Id</td><td>Name</td><td>Email</td><td>Contact</td><td>User Name</td><td>Password</td><td>Address</td><td>Action</td></tr>
    <c:forEach items="${custList}" var="c">
      <tr><td>${c.customerId}</td><td>${c.name}</td><td>${c.email}</td><td>${c.contact}</td><td>${c.userName}</td><td>${c.password}</td><td>${c.address}</td><td><a href="selectcustomer?id=${c.customerId}">Update</a>&nbsp;&nbsp;&nbsp;<a href="deletecustomer?id=${c.customerId}">Delete</a></td></tr>
    </c:forEach>
  </table><br>
  <a href="logout">Logout</a>
<%@include file="footer.html" %>
</body>
</html>
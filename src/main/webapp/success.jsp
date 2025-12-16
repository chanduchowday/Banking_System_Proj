<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="header.html" %>
</head>
<body>
<fieldset>
  <legend>Account Created Successfully</legend>
  <table>
    <tr><td>User Name</td><td>${uname}</td></tr>
     <tr><td>Account Id</td><td>${accountid}</td></tr>
  </table>
  <a href="login.jsp">Login Here</a> | <a href="index.jsp">Create Account</a>
</fieldset>
<%@include file="footer.html" %>
</body>
</html>
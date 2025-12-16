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
  <fieldset>
    <legend>Update Customer Profile</legend>
    <form action="updatecustomer" method="post">
      <table align="center">
        <tr><td><input type = "hidden" name="id" value="${c.customerId}"></td></tr>
        <tr><td>Name</td><td><input type="text" name="cname" value="${c.name}"></td></tr>
        <tr><td>Email</td><td><input type="text" name="cemail" value="${c.email}"></td></tr>
        <tr><td>Contact</td><td><input type="text" name="contact" value="${c.contact}"></td></tr>
        <tr><td>User Name</td><td><input type="text" name="cusername" value="${c.userName}"></td></tr>
        <tr><td>Password</td><td><input type="password" name="password" value="${c.password}"></td></tr>
        <tr><td>Address</td><td><input type="text" name="caddress" value="${c.address}"></td></tr>
        <tr><td><input type="submit" value="Update"></td></tr>
      </table>
    </form>
  </fieldset>
</body>
<%@include file="footer.html" %>
</html>
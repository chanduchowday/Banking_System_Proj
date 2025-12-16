<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="header.html" %>
</head>
<body>
  <h3 style="text-align: center;color: blue;">Welcome To Customer Page</h3><hr>
  <a href="profile">Profile</a> |  <a href="deposit.jsp">Deposit</a> | <a href="withdraw.jsp">Withdraw</a> | <a href="transactions">Transactions</a> | <a href="logout">Logout</a>
  <%@include file="footer.html" %>
</body>
</html>
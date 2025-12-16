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
  <fieldset>
    <legend>Deposit Form</legend>
    <form action="deposit" method="post">
      <table align="center">
         <tr><td>Amount</td><td><input type="text" name="amount"></td></tr>
         <tr><td><input type="submit" value="Deposit"></td></tr>
      </table>
    </form>
  </fieldset>
</body>
<%@include file="footer.html" %>
</html>
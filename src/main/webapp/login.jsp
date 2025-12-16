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
		<legend>Account Opening Form</legend>
		<form action="validatelogin" method="post">
			<table align="center">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="cusername"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="cpassword"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login">&nbsp;&nbsp;&nbsp;<input
						type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%@include file="footer.html" %>
</body>
</html>
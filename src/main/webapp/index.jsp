<html>
<head>
 <%@include file="header.html" %>
</head>
<body>
<fieldset>
  <legend>Account Opening Form</legend>
  <form action="createaccount" method="post">
    <table align="center">
      <tr><td>Name</td><td><input type="text" name="cname"></td></tr>
      <tr><td>Email</td><td><input type="text" name="cemail"></td></tr>
      <tr><td>Contact</td><td><input type="text" name="contact"></td></tr>
      <tr><td>UserName</td><td><input type="text" name="cusername"></td></tr>
      <tr><td>Password</td><td><input type="password" name="cpassword"></td></tr>
      <tr><td>Account Type</td><td><select name="atype">
        <option>>-----Select Type-------></option>
        <option value="Savings">Savings</option>
        <option value="Current">Current</option>
      </select></td></tr>
      <tr><td>Branch Name</td><td><select name="bname">
        <option>>-----Select Type-------></option>
        <option value="JNTU">JNTU</option>
        <option value="Ameerpet">Ameerpet</option>
        <option value="Nampally">Nampally</option>
        <option value="Uppal">Uppal</option>
      </select></td></tr>
      <tr><td>Address</td><td><textarea name="caddress" rows="5" cols="20"></textarea></td></tr>
      <tr><td><input type="submit" value="Create">&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear"></td></tr>
    </table>
    <h4 style="text-align: center;"><a href="login.jsp">Login</a>&nbsp;&nbsp;&nbsp;<a href="forgotpassword.jsp">Forgot Password</a></h4>
  </form>
</fieldset>
<%@include file="footer.html" %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 26.11.2015
  Time: 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration Form</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="register" method="post">
  <table cellpadding="3pt">
    <tr>
      <td>Name :</td>
      <td><input type="text" name="name" size="30" /></td>
    </tr>
    <tr>
      <td>Family</td>
      <td><input type="text" name="family" size="30" /></td>
    </tr>
    <tr>
      <td>email :</td>
      <td><input type="text" name="email" size="30" /></td>
    </tr>
    <tr>
      <td>Passport :</td>
      <td><input type="text" name="passport" size="30" /></td>
    </tr>
    <tr>
      <td>Adress :</td>
      <td><input type="text" name="adress" size="30" /></td>
    </tr>
    <tr>
      <td>Password :</td>
      <td><input type="password" name="password" size="30" /></td>
    </tr>
    <tr>
      <td>Berthday :</td>
      <td><input type="text" name="berthday" size="30" /></td>
    </tr>
  </table>
  <p />
  <input type="submit" value="Register" />
</form>
</body>
</html>


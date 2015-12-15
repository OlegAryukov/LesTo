<%@ page import="model.TarifEntity" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 03.12.2015
  Time: 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

    <body>
    <form action="/admin" method="post">
      <table width="750" border="0" cellspacing="5" cellpadding="0" align="center">
        <tr>
          <td align="center"><input type="submit" value="Клиенты" name="Clients"/></td>
        </tr>
        <tr>
          <td align="center"><input type="submit" value="Контракты" name="Contracts"/></td>
        </tr>
        <tr>
          <td align="center"><input type="submit" value="Тарифы" name="Tarifs"/></td>
        </tr>
        <tr>
          <td align="center"><input type="submit" value="Опции" name="Options"/></td>
        </tr>
      </table>
    </form>
    </body>
</html>

<%@ page import="model.ContractEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OptionsEntity" %>
<%@ page import="model.ClientEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 02.12.2015
  Time: 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
  ContractEntity contract = (ContractEntity) session.getAttribute("contract");
  ClientEntity user = (ClientEntity) session.getAttribute("user");
  List<OptionsEntity> conectList = contract.getConnectionOptions();
  List<OptionsEntity> avalOptions = contract.getTarifsByContractId().getAvaliableOptions();
  request.getSession().setAttribute("contract", contract);
  request.getSession().setAttribute("user", user);
%>
<form action="/addDel" method="POST">
<div align="center">
  <table width="900" border="2" cellspacing="0" cellpadding="0" style="background-color:#CCC">
    <tr>
      <td><div align="center">Подключенные опции</div></td>
      <td width="600"><div align="center">Доступные опции</div></td>
    </tr>
    <tr>
      <td><div align="center">
        <table width="250" border="2" cellspacing="0" cellpadding="0">
          <%for (OptionsEntity co:conectList){%>
          <tr>
            <td width="50"><div align="center" style="background-color:#09F"><input type="radio" name="del" value="<%=co.getOptionsId()%>"></div></td>
            <td><div align="center"style="background-color:#999"><%=co.getName()%></div></td>
          </tr>
          <%}%>
        </table>
      </div></td>
      <td><div align="center">
        <table width="550" border="2" cellspacing="0" cellpadding="0">
        <tr>
            <td width="50" border="0"><div align="center" style="background-color:#999"></div></td>
            <td width="300"><div align="center" style="background-color:#999">Название</div></td>
            <td width="100"><div align="center" style="background-color:#999">Цена</div></td>
            <td width="100"><div align="center" style="background-color:#999">Стоимость подключенния</div></td>
          </tr>
          <%for (OptionsEntity ao:avalOptions){%>
          <tr>
            <td width="50"><div align="center" style="background-color:#09F"><input type="radio" name="add" value="<%=ao.getOptionsId()%>"></div></td>
            <td width="300"><div align="center" style="background-color:#999"><%=ao.getName()%></div></td>
            <td width="100"><div align="center" style="background-color:#999"><%=ao.getPrice()%></div></td>
            <td width="100"><div align="center" style="background-color:#999"><%=ao.getConectCost()%></div></td>
          </tr>
          <%}%>
        </table>
      </div></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <table width="600" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><div align="center">
      <input type="submit" value="+ опция" name="AddOption"/>
      <input type="submit" value="- опция" name="DelOption"/>
    </div></td>
    </tr>
  </table>
</div>
</form>
</body>
</html>

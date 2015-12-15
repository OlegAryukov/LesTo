
<%@ page contentType="text/html; charset=utf-8" language="java" import="model.ClientEntity" errorPage="" %>
<%@ page import="model.ContractEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OptionsEntity" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Документ без названия</title>
</head>

<body>
<%
  ClientEntity user = (ClientEntity) session.getAttribute("user");
  List<ContractEntity> list = user.getContractsByClientId();
  request.getSession().setAttribute("user", user);
%>
<form action="/main" method="POST">
<p align="center">Добро пожаловать <%=user.getName()%>!</p>
<table width="1032" border="2" cellspacing="0" cellpadding="15" style="background-color:#CCC" align="center">
  <tr>
    <td width="450"><div align="center">Номер контракта</div></td>
    <td width="150"><div align="center">Тариф</div></td>
    <td width="150"><div align="center">Подключенные опции</div></td>
    <td width="150"><div align="center">Доступные опции</div></td>
  </tr>
  <%for (ContractEntity ce:list){%>
  <tr>
    <td><table width="437" height="31" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="50"><div align="center" style="background-color:#09F"><input type="radio" name="contractId" value="<%=ce.getContractId()%>"></div></td>
        <td width="350"><div align="center" style="background-color:#999"><%=ce.getPhoneNum()%></div></td>
      </tr>
    </table></td>
    <td><div align="center"style="background-color:#999"><%=ce.getTarifsByContractId().getName()%></div></td>
    <td><table width="250" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><table width="250" border="0" cellspacing="0" cellpadding="0">
          <%for (OptionsEntity oc:ce.getConnectionOptions()){%>
          <tr>
            <td><div align="center" style="background-color:#999"><%=oc.getName()%></div></td>
          </tr>
          <%}%>
        </table></td>
      </tr>
    </table></td>
   <td>
     <table width="250" border="0" cellspacing="0" cellpadding="0">
     <%for (OptionsEntity oa:ce.getTarifsByContractId().getAvaliableOptions()){%>
       <tr>
         <td><div align="center" style="background-color:#999"><%=oa.getName()%></div></td>
       </tr>
       <%}%>
     </table></td>
  <%}%>
</table>
<table width="750" border="0" cellspacing="0" cellpadding="15" align="center">
  <tr>
    <td><div align="center">
      <input type="submit" value="+ опция" name="AddOption"/>
      <input type="submit" value="- опция" name="DelOption"/>
      <input type="submit" value="Сменить тариф" name="ChangeTarif"/>
    </div>
   </td>
  </tr>
</table>
</form>
</body>
</html>
<%@ page import="model.ClientEntity" %>
<%@ page import="model.ContractEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="model.TarifEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 03.12.2015
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title></title>
  </head>
  <%
    ContractEntity contract = (ContractEntity) session.getAttribute("contract");
    ClientEntity user = (ClientEntity) session.getAttribute("user");
    List<TarifEntity> tl = (List<TarifEntity>) session.getAttribute("allTarif");
    request.getSession().setAttribute("contract", contract);
    request.getSession().setAttribute("user", user);
  %>
      <body>
        <form action="/changeTarif" method="POST">
        <div align="center">
          <table width="900" border="2" cellspacing="0" cellpadding="0" style="background:#CCC">
            <tr>
              <td align="center">Доступные тарифы</td>
            </tr>
            <tr>
              <td align="center">
                <table width="750" border="2" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="50"><div align="center" style="background-color:#999"></div></td>
                    <td width="350"><div align="center" style="background-color:#999">Название</div></td>
                    <td width="150"><div align="center" style="background-color:#999">Цена</div></td>
                  </tr>
                  <%for (TarifEntity t:tl){%>
                  <tr>
                    <td width="50"><div align="center" style="background-color:#09F"><input type="radio" name="tarifId" value="<%=t.getTarifId()%>"></div></td>
                    <td width="350"><div align="center" style="background-color:#999"><%=t.getName()%></div></td>
                    <td width="150"><div align="center" style="background-color:#999"><%=t.getPrice()%></div></td>
                  </tr>
                  <%}%>
              </table></td>
            </tr>
          </table>
          <p>&nbsp;</p>
          <table width="600" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><div align="center">
              <input type="submit" value="Сменить тариф" name="Change"/>
            </div></td>
            </tr>
          </table>
        </div>
        </form>
      </body>
  </html>

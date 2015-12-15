<%@ page import="java.util.Date" %>
<%@ page import="model.ClientEntity" %>
<%@ page import="model.ContractEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 30.11.2015
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="CSS/style.css"/>
  <title>Result Page</title>
</head>
<body>
<center>
  <div id="container">
      <%=new Date()%></br>
    <%
      ClientEntity user = (ClientEntity) session.getAttribute("user");
      List<ContractEntity> list = user.getContractsByClientId();
    %>
    <b>Welcome <%= user.getName() + " " + user.getFamily()%></b>
    <br/>
    <a href="logout.jsp">Logout</a>
    </p>

    <table>
      <thead>
        <tr><td>First Name<%= user.getName()%></td></tr>
        <tr><td>Last Name<%= user.getFamily()%></td></tr>
        <tr><td>email <%=user.getEmail()%></td></tr>
        <%for (ContractEntity a:list) {%>
          <tr><td><%=a.getPhoneNum()%></td></tr>
        <%}%>
      </thead>
    </table>
    <br/>
  </div>
</center>
</body>
</html>


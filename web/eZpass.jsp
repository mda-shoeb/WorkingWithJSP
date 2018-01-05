<%--
  Created by IntelliJ IDEA.
  User: mohammedshoeb
  Date: 11/9/17
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EZPass Billing System</title>
</head>
<body>
<h1>Welcome to EZPass Billing System</h1>
<p>Dear: ${username}</p>
<p> Your password: ${password}</p>
<form action="Ezpass" method="post">
    <h3> Enter your Details for EzPass Payment </h3>
    <h5>EZTagCode: </h5> <input type="text" name="eztagcode" width="30"  />
    <h5>TollPlaza: </h5> <input type="text" name="eztollplaza" width="30"  />
    <h5>Tollamount: </h5> <input type="text" name="eztollamount" width="30"  />


    <input type="submit" value="Pay" />
</form>
</body>
</html>

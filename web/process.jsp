<%--
  Created by IntelliJ IDEA.
  User: mohammedshoeb
  Date: 11/10/17
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
html>
<head>
    <title>EZPass Billing System</title>
</head>
<body>
</body>
</html>
<%
    String eztagcode=request.getParameter("eztagcode");
    String eztollplaza=request.getParameter("eztollplaza");
    String eztollamount=request.getParameter("eztollamount");


    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
        String query = " insert into userdata "
                + " values (?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, eztagcode);
        preparedStmt.setString (2, eztollplaza);
        preparedStmt.setString (3, eztollamount);
        preparedStmt.execute();
        out.println("<h1>Data is successfully inserted!<h1>");

        conn.close();



    }
    catch(Exception e)
    {
        System.out.print(e);
        e.printStackTrace();
    }
%>

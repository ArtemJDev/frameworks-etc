<%@ page import="Bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 15.09.2019
  Time: 20:18
  To change this template_data use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <jsp:useBean id="Student" class="Bean.Student" scope="session"/>
    <jsp:getProperty name="Student" property="name"/>
</body>
</html>

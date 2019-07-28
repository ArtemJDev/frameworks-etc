<%@ page import="main.java.testjdbc.TestConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Page-main</title>
</head>
<body>
    <%request.setCharacterEncoding("UTF-8");%>
    <h3>
        Привет -  ${param["username"]} <br>
    </h3>
<%
    TestConnection testConnection = new TestConnection();
    testConnection.check();
%>
</body>
</html>

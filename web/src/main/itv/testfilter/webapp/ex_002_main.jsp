<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 16.05.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jstl:choose>
    <jstl:when test="${empty sessionScope.user}">
        <p><a href="ex_002_register.jsp">Register</a></p>
        <p><a href="ex_002_login.jsp">Login</a></p>
    </jstl:when>
    <jstl:otherwise>
        <p>${sessionScope.user.name}</p>
        <p><a href="controller?action=logout">Logout</a></p>
    </jstl:otherwise>
</jstl:choose>

</body>
</html>

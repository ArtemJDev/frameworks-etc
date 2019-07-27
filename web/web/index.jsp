<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>First JSP App</title>
</head>
<body>
<%--post in, get out--%>
<form name="username" method="get" action="pages/main.jsp">
    <input type="text"  name="username"size="30">
    <input type="text" name="secondname"size="30">
    <input type="text" name="password"size="30">
    <input type="submit" value="Enter" >

</form>

</body>
</html>


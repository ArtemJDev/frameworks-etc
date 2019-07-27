<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Page-main</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
    %>
    <h3>
        Привет -  <%=request.getParameter("username")%> <br>
        Ваша фамилия : <%=request.getParameter("secondname")%><br>
        Ваш пароль : <%=request.getParameter("password")%>
        ${param["password"]} <%--EL--%>
    </h3>


</body>
</html>

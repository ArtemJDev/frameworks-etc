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
</body>
</html>

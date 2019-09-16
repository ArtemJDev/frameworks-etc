
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%! int i = 5; %>
<%! private void doJob() {
System.out.println("Hello");
}%>

<%doJob();%>

<%= i+1+2%>
<%--//Выполнение по условию--%>
<% if(i > 4) {%>
<h1>Hello World </h1>
<%}%>

<%--<jsp:include page="HelloJsp.jsp"/>--%>
<%--<jsp:forward page="HelloJsp.jsp"/>--%>

<jsp:useBean id="person" class="servlets.Person"/>
<%--<jsp:setProperty name="person" property="name" value="Max"/>--%>
<%--<jsp:getProperty name="person" property="name"  />--%>
</body>
</html>

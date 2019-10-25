<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
    <title>Title</title>
</head>
<body>

    <form:form method="post" modelAttribute="user" action="check-user" cssClass="box login">

        <fieldset class="boxBody">

            <form:label path="name">Name:</form:label>
            <form:input path="name"/>

            <form:label path="password">Password:</form:label>
            <form:input path="password"/>

        </fieldset>

        <footer>
            <label >
                <input type="checkbox" tabindex="3">Keep me logged in</label>
            <input type="submit" class="btnLogin" value="Login" tabindex="4">

        </footer>

    </form:form>

</body>
</html>

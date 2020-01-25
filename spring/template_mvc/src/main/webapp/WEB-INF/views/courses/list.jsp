<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<h1>Courses</h1>
<div id="userinfo">
    <s:authorize access="isAuthenticated()">
        <p>Hello <s:authentication property="principal.username"/>!</p>
        <a href="../j_spring_security_logout">Exit</a>
    </s:authorize>
    <s:authorize access="isAnonymous()">
        <form id="login" name="loginForm" action="/j_spring_security_check" method="post">
            <label>Login: </label>
            <input type="text" name="j_username">
            <label>Password: </label>
            <input type="password" name="j_password">
            <input type="submit" name="submit" value="Enter">
        </form>
    </s:authorize>
</div>
<c:if test="${not empty courses}">
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Time</td>
            <td>Description</td>
            <s:authorize access="hasRole('ROLE_USER')">
                <td></td>
                <td></td>
            </s:authorize>

        </tr>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.title}</td>
                <td>${course.length}</td>
                <td>${course.description}</td>
                <s:authorize access="hasRole('ROLE_USER')">
                    <td><a href="update/${course.id}">Edit</a></td>
                    <td><a href="delete/${course.id}">Delete</a></td>
                </s:authorize>

            </tr>
        </c:forEach>
    </table>
</c:if>

<s:authorize access="hasRole('ROLE_USER')">
    <a href="update/0">Add</a>
</s:authorize>

</body>
</html>

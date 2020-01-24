
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<h1>Courses</h1>
<c:if test="${not empty courses}">
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Time</td>
            <td>Description</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.title}</td>
                <td>${course.length}</td>
                <td>${course.description}</td>
                <td><a href="update/${course.id}">Edit</a></td>
                <td><a href="delete/${course.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="update/0">Add</a>
</body>
</html>

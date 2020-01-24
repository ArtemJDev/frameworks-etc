<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 24.01.2020
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit course</title>
    <style>
        form fieldset {
            width: 40%;
        }
        form fieldset label {
            display: block;
        }
        form fieldset input, form fieldset textarea {
            width: 100%;
        }
    </style>
</head>
<body>
    <h1>Course</h1>
    <form method="POST">
            <fieldset>
                <div>
                    <label>Name :</label>
                    <input type="text" name="title" value="${course.title}">
                </div>
                <div>
                    <label>Length :</label>
                    <input type="text" name="length" value="${course.length}">
                </div>
                <div>
                    <label>Description :</label>
                    <input type="text" name="description" value="${course.description}">
                </div>
                <div>
                    <input type="submit" value="Save">
                </div>
            </fieldset>
    </form>
</body>
</html>

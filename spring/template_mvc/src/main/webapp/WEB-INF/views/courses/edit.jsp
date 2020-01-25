<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
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
    <s:authorize access="isAnonymous()">
        <script>
          let disableForm = true;
          window.addEventListener("load", () => {
            if (disableForm) {
              let inputs = document.querySelectorAll("form fieldset input, form fieldset textarea");
              for (let i = 0; i < inputs.length; i++) {
                inputs[i].disabled = true;
              }
            }
          })
        </script>
    </s:authorize>
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

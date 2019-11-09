<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"> </script>

    <script type="text/javascript">
      function doAjax() {
        $.ajax({
          url: 'checkStrength',
          data: ({password : $('#password').val()}),
          success: function (data) {
            $('#strengthValue').html(data);
          }
        });
      }
    </script>
</head>
<body>

    <form:form method="post" modelAttribute="user" action="check-user" cssClass="box login">

        <fieldset class="boxBody">

            <span style="float: right">
            <a href="?lang=en">en</a>
            <a href="?lang=ru">ru</a>
            </span>

            <form:label path="name"><spring:message code="username"/>:</form:label>
            <form:input path="name"/>

            <form:label path="password" ><spring:message code="password"/>:</form:label>
            <form:input path="password" onkeyup="doAjax()"/>
            <span style="float: right" id="strengthValue"></span>

        </fieldset>

        <footer>
            <label >
                <input type="checkbox" tabindex="3">Keep me logged in</label>
            <input type="submit" class="btnLogin" value="Login" tabindex="4">

        </footer>

    </form:form>

</body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">

</head>
<body>

<p>`Hello ${user.name}</p>
<p>Your password is ${user.password}</p>
<p>Are you Admin? ${user.admin}</p>
<p>Locale : ${locale}</p>


</form>
</body>
</html>

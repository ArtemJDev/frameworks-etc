<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<h1>All cars:</h1>
<table cellpadding="1" cellspacing="1" border="1">
    <tr>
        <td>Id</td>
        <td>Mark</td>
        <td>Model</td>
        <td>Price</td>
    </tr>
    <c:forEach items="${cars}" var="car">
      <tr>
           <c:choose>
               <c:when test="${car.price >= 100000}">
                   <td>${car.id}</td>
                   <td>${car.mark}</td>
                   <td>${car.model}</td>
                   <td>${car.price}</td>
               </c:when>
               <c:otherwise>
                   <td colspan="4" align="center">Bad car</td>
               </c:otherwise>
           </c:choose>
      </tr>
    </c:forEach>
</table>
</body>
</html>

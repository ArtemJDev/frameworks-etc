<%@ page import="main.java.beans.Author" %>
<%@ page import="main.java.beans.AuthorList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../bootstrap-grid.min.css">
    <!--  CSS -->
    <link rel="stylesheet" href="../css/style.css">
    <title>Онлайн склад</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<div class="one">
    <div class="two">
        <img class="two_img" src="../images/migration-1.png" alt="123">
    </div>
    <div class="search">
        <form class="search_name" name="search_form" action="post">
            <img class="search_img" src="../images/search.png" alt="поиск">
            <input type="text" name="search_string" size="30">
            <input type="submit" name="search_button" value="Поиск">
            <select name="search_option" >
                <option>Название</option>
                <option>Автор</option>
            </select>
        </form>

    </div>
    <div class="factory">
        <p>Список заводов</p>
        <ul>

            <%
                AuthorList authorList = new AuthorList();
                for(Author author : authorList.getAuthorList()) {
            %>
            <li><a href="#"><%= author.getName()%></a></li>
            <%}%>
        </ul>
    </div>
    <div class="detail">
        <p>Список деталей</p><br>
    </div>
    <div class="footer">футер</div>
</div>
</body>
</html>

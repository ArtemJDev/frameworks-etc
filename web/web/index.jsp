<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap-grid.min.css">

    <!--  CSS -->
    <link rel="stylesheet" href="css/lib_style.css">

    <title>ru</title>
</head>
<body>
<div class="test">
    <div class="content">
        <img class="test_img" src="images/migration-1.png" alt="">
        <h1>Ваш склад онлайн: version 0.0</h1>
        <p>Добро пожаловать на склад, вы можете посмотреть запасы любого товара и заказать его.
            Воспользуйтесь поиском и просмотром.</p>
        <p>Для авторизации введите свое имя</p>
    </div>
    <div class="form">
        <form class="test_input_usern" name="username" method="get" action="pages/main.jsp">
            <input type="text" name="username" size="30">
            <input class="test_button" type="submit" value="Войти">
        </form>
    </div>
</div>

</body>
</html>

<%@page import="main.java.enums.SearchType"%>
<%@page import="main.java.beans.Book"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>
<jsp:useBean id="bookList" class="main.java.beans.BookList" scope="page"/>
<%@include file="../WEB-INF/jspf/letters.jspf" %>

<div class="detail">

    <%request.setCharacterEncoding("UTF-8");
        ArrayList<Book> list = null;

        if (request.getParameter("genre_id") != null) {
            long genreId = Long.valueOf(request.getParameter("genre_id"));
            list = bookList.getBooksByGenre(genreId);
        } else if (request.getParameter("letter") != null) {
            String letter = request.getParameter("letter");
            list = bookList.getBooksByLetter(letter);
        } else if (request.getParameter("search_string") != null) {
            String searchStr = request.getParameter("search_string");
            SearchType type = SearchType.TITLE;
            if (request.getParameter("search_option").equals("Автор")) {
                type = SearchType.AUTHOR;
            }

            if (searchStr != null && !searchStr.trim().equals("")) {
                list = bookList.getBooksBySearch(searchStr, type);
            }
        }
    %>
    <h5 style="text-align: left; margin-top:20px;">Найдено деталей: <%=list.size() %> </h5>
    <%
        session.setAttribute("currentBookList", list);
        for (Book book : list) {
    %>



    <div style="text-align: center; margin-bottom: 5px;"><h3>${param.name}</h3></div>

    <table cellpadding="30" style="font-size: 12px;">

        <tr >
            <td style="width:400px;height: 100px;">
                <p style="color:#378de5 ;font-weight: bold; font-size: 15px;"> <%=book.getName()%></p>
                <br><strong>Код-детали:</strong> <%=book.getIsbn()%>
                <br><strong>Группа-компаний:</strong> <%=book.getPublisher() %>

                <br><strong>Вес:</strong> <%=book.getPageCount() %> г.
                <br><strong>Дата производства:</strong> <%=book.getPublishDate() %>
                <br><strong>Завод:</strong> <%=book.getAuthor() %>
                <p style="margin:10px;"> <a href="#">Информация</a></p>
            </td>
            <td style="width:150px;height: 100px;">
                <img src="<%= request.getContextPath()%>/ShowImage?index=<%=list.indexOf(book)%>" width="100px">
            </td>
        </tr>
        <%}%>
    </table>
</div>


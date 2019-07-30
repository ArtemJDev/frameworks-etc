<%@page import="main.java.beans.Book"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<%request.setCharacterEncoding("UTF-8");

    long genreId = 0L;

    try {
        genreId = Long.valueOf(request.getParameter("genre_id"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>

<jsp:useBean id="bookList" class="main.java.beans.BookList" scope="page"/>



<div class="detail">
    <div style="text-align: center; margin-bottom: 5px;"><h3>${param.name}</h3></div>

    <table cellpadding="30" style="font-size: 12px;">

        <%
            ArrayList<Book> list = bookList.getBooksByGenre(genreId);
            session.setAttribute("currentBookList", list);
            for (Book book : list) {

        %>
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
                <br><strong>Картинка</strong>
                <img src="<%= request.getContextPath()%>/ShowImage?index=<%=list.indexOf(book)%>" width="50px">
                <%=book.getImage()%>
            </td>
        </tr>
        <%}%>


    </table>
</div>

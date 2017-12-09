<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>

<%

    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.println("Brak autora lub wiadomosci");
    }

    String author = "";

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("author")) author = cookie.getValue();
        }
    }

%>

<form action="/postServlet" method="post">
    Author:<br>
    <input name="author" value="<% out.print(author); %>"> <br><br>
    Message:<br>
    <textarea name="message"></textarea> <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
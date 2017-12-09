<%@ page import="com.sdatwitter.service.MyTwitterService" %>
<%@ page import="com.google.common.base.Strings" %>
<%@ page import="tweetcom.sdatwitter.model.MyTweet" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>

<%

    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.println("Brak autora lub wiadomosci");
    }

%>

<form action="/postServlet" method="post">
    Author:<br>
    <input name="author"> <br><br>
    Message:<br>
    <textarea name="message"></textarea> <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
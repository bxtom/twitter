<%@ page import="com.sdatwitter.service.MyTwitterService" %>
<%@ page import="com.sdatwitter.model.MyTweet" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>
<%! MyTwitterService service =  MyTwitterService.getInstance(); %>

<h2>List of tweets</h2>

<a href="publish.jsp">publish new tweet</a><br><br>

<table border="1">

    <th width="150px">author</th>
    <th width="150px">message</th>
    <th width="300px">timestamp</th>

<%

    for (MyTweet tweet : service.getTweetList()){
        out.println("<tr>");
        out.println("<td>" + tweet.getAuthor() + "</td>");
        out.println("<td>" + tweet.getTweet() + "</td>");
        out.println("<td>" + tweet.getTimestamp() + "</td>");
        out.println("</tr>");
    }

%>

</table>

</body>
</html>
package com.sdatwitter.servlets;

import com.google.common.base.Strings;
import com.sdatwitter.Database.DatabaseDAO;
import com.sdatwitter.service.MyTwitterService;
import com.sdatwitter.model.MyTweet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "postServlet", value = "/postServlet")
public class TweetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String author = req.getParameter("author");
        String message = req.getParameter("message");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // create HTML response
        PrintWriter writer = resp.getWriter();


        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Titlr</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");
        if (Strings.isNullOrEmpty(req.getParameter("author")) ||
                Strings.isNullOrEmpty(req.getParameter("message"))) {
            //resp.addHeader("error", "not_author");
            resp.sendRedirect("/publish.jsp?error");

        } else {
            MyTwitterService service =  MyTwitterService.getInstance();
            MyTweet myTweet = new MyTweet(author,message, System.currentTimeMillis());
            //service.addTweet(myTweet);
            DatabaseDAO.addTweet(myTweet);

            Cookie authorCookie = new Cookie("author", author);
            authorCookie.setMaxAge(30*60);
            resp.addCookie(authorCookie);

            writer.append("	Dodano tweet\r\n");

            resp.sendRedirect("/index.jsp");
        }

        writer.append("		</body>\r\n")
                .append("</html>\r\n");

    }
}

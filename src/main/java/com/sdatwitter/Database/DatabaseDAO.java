package com.sdatwitter.Database;

import com.sdatwitter.model.MyTweet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DatabaseDAO {
    public static void addTweet(MyTweet tweet) {
        Connection conn = null;
        Statement stmt = null;
        try {
            System.out.println("Connecting to database...");
            conn = Database.getConnection();
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO tweets (author, message, timestamp) " +
                    "VALUES ('" + tweet.getAuthor() + "', '" + tweet.getTweet() + "', '" + tweet.getTimestamp() + "');";

            System.out.println(sql);

            int result = stmt.executeUpdate(sql);
            System.out.println("Result: " + result);

            //stmt.close();
            //conn.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }

    public static List<MyTweet> getTweetList() {
        Connection conn = null;
        Statement stmt = null;

        List<MyTweet> myTweetList = new LinkedList<MyTweet>();

        try {
            System.out.println("Connecting to database...");
            conn = Database.getConnection();
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM tweets";
            ResultSet rs = stmt.executeQuery(sql);

            rs.last();
            int total = rs.getRow();
            System.out.println("results count: " + total);
            rs.beforeFirst();

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                MyTweet tweet = new MyTweet(rs.getString("author"),
                        rs.getString("message"),
                        rs.getLong("timestamp"));
                myTweetList.add(tweet);
            }
            //STEP 6: Clean-up environment
            //stmt.close();
            //conn.close();

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Goodbye!");

        return myTweetList;
    }
}

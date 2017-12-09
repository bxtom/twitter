package com.sdatwitter.service;

import tweetcom.sdatwitter.model.MyTweet;

import static java.util.Collections.unmodifiableList;
import java.util.LinkedList;
import java.util.List;

public class MyTwitterService {
    private static MyTwitterService instance;

    private List<MyTweet> myTweetList;

    private MyTwitterService() {
        myTweetList = new LinkedList<MyTweet>();
    }

    public static MyTwitterService getInstance() {
        if (instance == null) {
            instance = new MyTwitterService();
        }

        return instance;
    }

    public void addTweet(MyTweet tweet) {
        myTweetList.add(tweet);
    }

    public List<MyTweet> getTweetList() {
        //return myTweetList;
        return unmodifiableList(myTweetList);
    }
}

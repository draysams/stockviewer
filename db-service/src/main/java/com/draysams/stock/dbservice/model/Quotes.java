package com.draysams.stock.dbservice.model;

import java.util.List;

public class Quotes {

    private List<String> quotes;
    private String userName;

    public Quotes(List<String> quotes, String userName) {
        this.quotes = quotes;
        this.userName = userName;
    }

    public Quotes() {

    }

    public List<String> getQuotes() {

        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

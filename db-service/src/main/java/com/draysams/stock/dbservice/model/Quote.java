package com.draysams.stock.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "quote", catalog = "test")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public Quote() {
    }

    public Quote(String username, String quote) {
        this.username = username;
        this.quote = quote;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Column(name = "user_name")
    private String username;

    @Column(name = "quote")
    private String quote;
}

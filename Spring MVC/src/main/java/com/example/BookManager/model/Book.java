package com.example.BookManager.model;

public class Book {
    private String name;
    private Integer id;

    private Integer price;
    private Integer authorId;

    public Book(String name, Integer id, Integer price, Integer authorId) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}

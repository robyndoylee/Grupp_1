package com.example.Grupp1;

public class Joke {
    Long id;
    String title;
    Enum CATEGORY;
    String body;
    String author;

    public Joke(Long id, String title, Enum CATEGORY, String body, String author) {
        this.id=id;
        this.title = title;
        this.CATEGORY = CATEGORY;
        this.body = body;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Enum getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(Enum CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

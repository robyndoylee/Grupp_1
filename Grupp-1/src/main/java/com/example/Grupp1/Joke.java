package com.example.Grupp1;

public class Joke {
    String title;
    String category;
    String body;
    String author;
    Long id;

    public Joke(String title, String category, String body, String author, Long id) {
        this.title = title;
        this.category = category;
        this.body = body;
        this.author = author;
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

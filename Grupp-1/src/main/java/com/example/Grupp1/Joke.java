package com.example.Grupp1;


import java.util.ArrayList;

public class Joke {
    private int id;
    private String title;
    private String category;
    private String body;
    private String author;
    private ArrayList<Rate> rating;

    public Joke(int id, String title, String category, String body, String author) {
        this.id=id;
        this.title = title;
        this.category = category;
        this.body = body;
        this.author = author;
        this.rating = new ArrayList<>();

    }
    public void addRating(Rate rate){
        this.rating.add(rate);
    }

    public int averageRating(){
        int sum =0;
        int count =0;
        for (Rate rate : rating ) {
        sum = sum + rate.getRating();
        count++;
        }
        int average = sum/count;
        return average;
    }

    public Joke(){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

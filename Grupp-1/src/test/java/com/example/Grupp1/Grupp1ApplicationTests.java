package com.example.Grupp1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Grupp1ApplicationTests {

    @Autowired
    private Repo repo;

    @Autowired
    private JokeService jokeService;

    @Test
    void contextLoads() {
    }

    @Test
    void testId() {

        Joke joke = new Joke(10, "Title", "Family", "Hej hej ", "Lwam");
        Assertions.assertEquals(10, joke.getId());
    }

    @Test
    void generateRandomIdNumber() {
        int numberOfJokes = repo.numberOfJokes();
        Assertions.assertEquals(1, jokeService.randomJoke());
    }





    @Test
    void test() {
        Joke joke = new Joke(10, "Title", "Family", " HEJ HEJ ROLIGT", "Lwam");
        Assertions.assertEquals("Title", joke.getTitle());
    }

    @Test
    void getJokeById() {
        Joke joke = repo.getJoke(1);
        Assertions.assertEquals("Test", joke.getTitle());

    }

    @Test
    void numberOfJokes() {
        Assertions.assertEquals(1, repo.numberOfJokes());
    }

    @Test
    void averageRatingForJokeWithId() {
        Assertions.assertEquals(3.5, repo.averageRating(1));
    }

    @Test
    void addRating(){
        repo.addRating(1,1);
        repo.addRating(1,1);
        repo.addRating(1,2);
        repo.addRating(1,3);
        Assertions.assertEquals(2.3, repo.averageRating(1));
    }

    @Test
    void testaddjoke() {
//      repo.addJoke(new Joke(null,"NewTitle", "Family", " HEJ HEJ ROLIGT", "Lwam"));

        Assertions.assertEquals(2, repo.addJoke(new Joke(null,"NewTitle1", "Family3", " HEJ HEJ ROLIGT", "Lwam")));
    }
}


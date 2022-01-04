package com.example.Grupp1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {
    private List<Joke> jokes;

    public Repo() {
        jokes = new ArrayList<>();



        jokes.add(new Joke("Title", "Family"," HEJ HEJ ROLIGT", "Lwam",1L));
        jokes.add(new Joke("New title", "General","", "Robyn",2L));
        jokes.add(new Joke("Some title", "Adult","", "",3L));
        jokes.add(new Joke("Hello this is my title", "General","", "",4L));
        jokes.add(new Joke("No title", "General","", "",5L));
        jokes.add(new Joke("  1  1   2", "Adult","", "",6L));
        jokes.add(new Joke("YES!", "Adult","", "",7L));

    public Joke getJoke(Long id) {
        for (Joke joke : jokes) {
            if (joke.getId().equals(id)) {
                return joke;
            }
        }
        return null;
    }

    public Joke addJoke(Joke joke) {
        Joke lastJoke = jokes.get(jokes.size()-1);
        joke.setId(lastJoke.getId()+1);
        jokes.add(joke);
        return joke;
    }
}

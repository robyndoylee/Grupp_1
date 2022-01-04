package com.example.Grupp1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {
    private List<Joke> jokes;

    public Repo() {
        jokes = new ArrayList<>();

        jokes.add(new Joke(1L, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(2L, "Title", "Adult"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(3L, "Title", "General"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(4L, "Title", "General"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(5L, "Title", "Adult"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(6L, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));

        }

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

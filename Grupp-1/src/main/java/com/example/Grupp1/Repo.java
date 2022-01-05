package com.example.Grupp1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {
    private List<Joke> jokes;

    public Repo() {
        jokes = new ArrayList<>();

        jokes.add(new Joke(1, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(2, "Title", "Adult"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(3, "Title", "General"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(4, "Title", "General"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(5, "Title", "Adult"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(6, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));

        }

    public Joke getJoke(int id) {
        for (Joke joke : jokes) {
            if (joke.getId()==(id)) {
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

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
//            for (int i = 1; i <= 9; i++) {
//                jokes.add(new Joke(new String("Title"+i), "Book Title " + i, "Author name " + i, 40 + i));
//            }
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

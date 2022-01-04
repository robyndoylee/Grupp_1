package com.example.Grupp1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {
    private List<Joke> jokes;

    public Repo() {
        jokes = new ArrayList<>();



        jokes.add(new Joke(1L, "Title", CATEGORY.FAMILY," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(2L, "Title", CATEGORY.FAMILY," HEJ HEJ ROLIGT2", "Lwam"));
        jokes.add(new Joke(3L, "Title", CATEGORY.FAMILY," HEJ HEJ ROLIGT3", "Lwam"));
        jokes.add(new Joke(4L, "Title", CATEGORY.FAMILY," HEJ HEJ ROLIGT4", "Lwam"));
        jokes.add(new Joke(5L, "Title", CATEGORY.FAMILY," HEJ HEJ ROLIGT5", "Lwam"));
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
}

package com.example.Grupp1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class Repo {
    private List<Joke> jokes;

    public Repo() {
        jokes = new ArrayList<>();

        jokes.add(new Joke(1, "Alive", "Dark","I'm alive because of two reasons:\n 1. I was born. \n2. I haven't died yet.", "Simon"));
        jokes.add(new Joke(2, "Stabbed", "Dark","I just read that someone in London gets stabbed every 52 seconds. Poor guy.", "Simon"));
        jokes.add(new Joke(3, "I work with animals", "Dark","I work with animals,\" the guy says to his date.  \"That's so sweet,\" she replies. \"I love a man who cares about animals. Where do you work?\"\n\"I'm a butcher,\" he says", "Simon"));
        jokes.add(new Joke(4, "Substitute", "Adult","What does tofu and a dildo have in common? They are both meat substitutes.", "Simon"));
        jokes.add(new Joke(5, "The hint", "Adult","A woman walks out of the shower, winks at her boyfriend, and says, “Honey, I shaved myself down there. Do you know what that means?” The boyfriend says, “Yeah, it means the drain is clogged again.”", "Simon"));
        jokes.add(new Joke(6, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(7, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(8, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(9, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));
        jokes.add(new Joke(10, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam"));

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

    public int numberOfJokes() {

        return jokes.size();
    }
    public int randomJoke() {

        return ThreadLocalRandom.current().nextInt(1,jokes.size()+1);   // Från ID 1 till och med sista elementet i listan

    }



}

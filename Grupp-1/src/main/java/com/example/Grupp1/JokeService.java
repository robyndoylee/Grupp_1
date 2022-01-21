package com.example.Grupp1;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadLocalRandom;

public class JokeService {


    @Autowired
    private Repo repo;
    private JokeService JokeService;

    public int randomJoke() {
// Koppla ihop med SQL. Tidigare kod nedan:
//        return ThreadLocalRandom.current().nextInt(1,jokes.size()+1);   // Från ID 1 till och med sista elementet i listan


return 0;
    }

    public int[] pagArray(int length, int id) {
        int start = Math.max(1, id - 5);

        if (repo.numberOfJokes() - id < 5) {    // Lägg inte till länkar om aktiv länk är närmare än 5 ifrån sista ID
            start = repo.numberOfJokes() - 8;
        }

        int[] array = new int[length];
        // aktiv länk/sida skall vara i mitten av pagination (plats 5 av 10)

        for (int i = 0; i < length; i++) {
            array[i] = start;
            start++;
        }
        return array;  // ändra till giltigt return value
    }


}
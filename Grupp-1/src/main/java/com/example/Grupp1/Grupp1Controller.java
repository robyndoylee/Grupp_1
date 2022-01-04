package com.example.Grupp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Grupp1Controller {

    @Autowired
    private Repo repo;

    @GetMapping("/")
    String start(Model model) {
        return "start";
    }


    @GetMapping("/add")
    String start3(Model model) {
        model.addAttribute("joke", new Joke());
        return "form";
    }

    @PostMapping("/add")
    String start1(Model model, @ModelAttribute Joke joke) {
        repo.addJoke(joke);
        model.addAttribute("joke", joke);
        return "test2";

    }

    @GetMapping("/view")
    String start4(Model model, @RequestParam(required = false, defaultValue = "1") int id) {

        Joke joke = repo.getJoke(id);
        int numberOfJokes = repo.numberOfJokes();
        int paginationLength = Math.min(numberOfJokes, 10);
        int[] paginationElements = pagArray(paginationLength, id);


        model.addAttribute("joke", joke);
        model.addAttribute("id", id);

//        For pagination
        model.addAttribute("showPrevious", id > 1);
        model.addAttribute("currentPage", id);
        model.addAttribute("numberOfJokes", numberOfJokes);
        model.addAttribute("elements", paginationElements);
        model.addAttribute("showNext", numberOfJokes > id);


        return "view";
    }

    private int[] pagArray(int length, int id) {
        int start = Math.max(1, id - 5);          // aktiv länk/sida skall vara i mitten av pagination (plats 5 av 10)


        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = start;
            start++;
        }

        return array;
    }


}
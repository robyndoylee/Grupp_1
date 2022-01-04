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
    String start1 (Model model, @ModelAttribute Joke joke){
        repo.addJoke(joke);
        model.addAttribute("joke",joke);
        return "test2";

    }

    @GetMapping("/view")
    String start4(Model model, @RequestParam(required = false, defaultValue = "1") Long id) {

        Joke joke = repo.getJoke(id);
        model.addAttribute("joke", joke);
        model.addAttribute("id", id);
        return "view";
    }

}
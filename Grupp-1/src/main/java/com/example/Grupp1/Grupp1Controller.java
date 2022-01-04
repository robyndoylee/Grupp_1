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


    @PostMapping("/add")
    String start1 (Model model, Joke joke){
        model.addAttribute("joke",joke);
        return "view";
    }

    @GetMapping("/add")
    String start3(Model model, Joke joke) {
        model.addAttribute("joke", joke);
        return "form";
    }

    @GetMapping("/view")
    String start4(Model model, @RequestParam(required = false, defaultValue = "1") Long id) {

        Joke joke = repo.getJoke(id);
        model.addAttribute("joke", joke);
        model.addAttribute("id", id);
        return "view";
    }

}
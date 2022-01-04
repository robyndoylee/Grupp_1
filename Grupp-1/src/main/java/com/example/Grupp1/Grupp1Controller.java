package com.example.Grupp1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Grupp1Controller {

    @GetMapping("/")
    String start(Model model) {
        return "start";
    }


    @PostMapping("/")

}
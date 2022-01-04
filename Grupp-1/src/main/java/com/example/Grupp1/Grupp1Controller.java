package com.example.Grupp1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Grupp1Controller {

    @GetMapping("/")
    String start(Model model){
        return "start";
    }

}

package com.example.Grupp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;

@Controller
public class Grupp1Controller {

    @Autowired
    private Repo repo;

    @GetMapping("/")
    String start(HttpSession session, Model model) {

        session.getAttribute("admin");

        model.addAttribute("random", repo.randomJoke());
        return "start";
    }

    @GetMapping("/add")
    String start3(HttpSession session, Model model) {
        model.addAttribute("joke", new Joke());
        return "form";
    }

    @PostMapping ("/addRating")
    String start123 (@RequestParam int rate , @RequestParam int id, Model model){
        model.addAttribute("rate",rate);
        Joke joke = repo.getJoke(id);
        joke.addRating(new Rate(rate));
        System.out.println(rate);
        System.out.println(joke.averageRating());
        return "redirect:/view?id=" +id;
    }

    @PostMapping("/add")
    String start1(Model model, @ModelAttribute Joke joke, BindingResult result) {
        repo.addJoke(joke);
        model.addAttribute("joke", joke);
        if (joke.getBody() == null || joke.getBody().equals("")) {
            result.rejectValue("body", "body.empty");
            return "form";

        } else if (joke.getAuthor().equals("")) {
            result.rejectValue("author", "author.empty");
            return "form";

        } else if (joke.getTitle().equals("")) {
            result.rejectValue("title", "title.empty");
            return "form";
        }
        return "test2";
    }

    @GetMapping("/view")
    String start4(HttpSession session, Model model, @RequestParam(required = false, defaultValue = "1") int id) {

        session.getAttribute("admin");

        Joke joke = repo.getJoke(id);

        int numberOfJokes = repo.numberOfJokes();
        int paginationLength = Math.min(numberOfJokes, 9);
        int[] paginationElements = pagArray(paginationLength, id);


        model.addAttribute("joke", joke);
        model.addAttribute("id", id);
        model.addAttribute("random", repo.randomJoke());
        model.addAttribute("averageRating", joke.averageRating());

//        For pagination
        model.addAttribute("showPrevious", id > 1);
        model.addAttribute("numberOfJokes", numberOfJokes);
        model.addAttribute("elements", paginationElements);
        model.addAttribute("showNext", numberOfJokes > id);

        return "view";
    }

    @GetMapping("/admin")
    public String logOn(HttpSession session) {

        return "login";
    }

    @PostMapping("/login")
    public String admin(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("test123")) {
            session.setAttribute("admin", true);
            return "redirect:/";

        }
        return "login";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {

        // Kanske räcker med ett av dessa... men vafan...
        session.removeAttribute("username");
        session.invalidate();

        return "redirect:/";
    }



    private int[] pagArray(int length, int id) {
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
        return array;
    }


}
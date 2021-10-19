package com.example.useofstaticweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {

    private int counter;

    @GetMapping("/visit")
    public String visit(Model model){
        counter++;
        model.addAttribute("counter", counter);
        return "visit";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loggedin")
    public String loggedIn(){
        return "loggedin";
    }

}

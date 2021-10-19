package com.example.useofstaticweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {

    private int counter;

    @GetMapping("/")
    public String visit(Model model){
        counter++;
        model.addAttribute("counter", counter);
        return "visit";
    }

}

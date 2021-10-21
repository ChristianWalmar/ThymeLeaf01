package com.example.useofstaticweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {

    private int counter;

    @GetMapping("/visit")
    public String visit(Model model){
        counter++;
        model.addAttribute("counter", counter);
        return "visit";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/index")
    public String index(@RequestParam String userName,@RequestParam String password, Model model){
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        UserService userService = new UserService();

        boolean loginSuccessful = userService.checkLogin(userName,password);

        if (loginSuccessful==true){
            return "index";
        }else {
            model.addAttribute("failedLogin","Username or password does not exist?!?!");
            return "login";
        }

    }

    @PostMapping("/create")
    public String create(@RequestParam String userName,@RequestParam String password, Model model){
        UserService userService = new UserService();
        userService.createUser(userName,password);
        return "login";
    }

    @GetMapping("/loggedin")
    public String loggedIn(){
        return "loggedin";
    }

}

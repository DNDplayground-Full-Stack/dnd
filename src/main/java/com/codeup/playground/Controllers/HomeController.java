package com.codeup.playground.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "Landing";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @GetMapping("/logout")
    public String showLogoutForm() {
        return "users/logout";
    }
}

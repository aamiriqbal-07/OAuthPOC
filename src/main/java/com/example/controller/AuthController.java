package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/authorization/azure";
    }

    @GetMapping("/signup")
    public String signup() {
        return "redirect:/oauth2/authorization/azure";
    }
}

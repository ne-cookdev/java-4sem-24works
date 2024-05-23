package com.example.lesson16.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.lesson16.service.UserAppService;
import com.example.lesson16.model.User;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class AuthController {
    private UserAppService applicationUserService;

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("")
    public String getIndexPage() {
        return "home";
    }

    @GetMapping("registration")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("registration")
    public String signUpUser(@ModelAttribute("user") User user) {
        return applicationUserService.signUpUser(user);
    }
}
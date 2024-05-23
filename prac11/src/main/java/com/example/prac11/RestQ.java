package com.example.prac11;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestQ {
    @RequestMapping("/")
    public String rest(){
        return "REST_TEST";
    }
}

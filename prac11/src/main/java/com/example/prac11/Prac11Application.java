package com.example.prac11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Prac11Application {
    public static void main(String[] args) {
        SpringApplication.run(Prac11Application.class, args);
        RestQ rest = new RestQ();
        rest.rest();
    }
}

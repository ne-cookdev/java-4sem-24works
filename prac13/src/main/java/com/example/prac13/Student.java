package com.example.prac13;

import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;

    public Student() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Student: "+ name + " " + last_name + " " + group);
    }


}
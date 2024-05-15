package com.example.lesson12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    private final FileMaster master;

    @Autowired
    public Main(FileMaster master) {
        this.master = master;
    }

    public static void main(String[] args) throws Exception {
        // Создать файл input.txt перед запуском т.к. он удаляется при выключении
        SpringApplication.run(Main.class, args);
    }
}

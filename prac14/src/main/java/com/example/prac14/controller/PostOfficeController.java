package com.example.prac14.controller;

import com.example.prac14.PostOffice;
import com.example.prac14.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostOfficeController {
    @Autowired
    private PostOfficeService service;

    @PostMapping("/postPostOffice")
    public void postPostoffice(@RequestBody PostOffice postOffice) {
        service.addOrder(postOffice);
    }

    @GetMapping("/getPostOffice")
    public List<PostOffice> getAll() {
        return service.getOrders();
    }

    @DeleteMapping("/deletePostOffice")
    public void deletePostoffice(@RequestBody PostOffice postOffice) {
        service.deleteOrder(postOffice);
    }
}

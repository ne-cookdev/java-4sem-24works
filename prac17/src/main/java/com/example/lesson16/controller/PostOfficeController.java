package com.example.lesson16.controller;

import com.example.lesson16.model.Departure;
import com.example.lesson16.model.PostOffice;
import com.example.lesson16.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PostOfficeController {
    @Autowired
    private PostOfficeService service;

    @PostMapping("/postOffice")
    public void post(@RequestBody PostOffice postOffice) {
        service.addPostOffice(postOffice);
    }

    @GetMapping("/postOffices")
    public List<PostOffice> getAll() {
        return service.getPostOffice();
    }

    @GetMapping("/postOffices/name/{name}")
    public List<PostOffice> getAllByOrderDate(@PathVariable String name) {
        return service.findOrdersByOrderDate(name);
    }

    @GetMapping("/postOffice/{id}")
    public List<PostOffice> get(@PathVariable UUID id) {
        return service.getPostOffice(id);
    }

    @DeleteMapping("/postOffice/{id}")
    public void delete(@PathVariable UUID id) {
        service.deletePostOffice(id);
    }

    @GetMapping("/postOffice/{id}/departures")
        public List<Departure> getPostOfficesByOrder(@PathVariable UUID id) {
            return service.getPostOfficesByOrder(id);
        }
}

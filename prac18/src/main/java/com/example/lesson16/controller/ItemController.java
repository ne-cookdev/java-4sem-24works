package com.example.lesson16.controller;

import com.example.lesson16.model.Item;
import com.example.lesson16.service.ItemServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceImplementation service;

    @PostMapping("/item")
    public void post(@RequestBody Item item) {
        service.addItem(item);
    }

    @GetMapping("/items")
    public List<Item> getAll() {
        return service.getItems();
    }

    @GetMapping("/items/name/{name}")
    public List<Item> getAllByName(@PathVariable String name) {
        return service.findItemsByName(name);
    }

    @GetMapping("/items/creationDate/{creationDate}")
    public List<Item> getAllByCreationDate(@PathVariable int creationDate) {
        return service.findItemsByCreationDate(creationDate);
    }

    @GetMapping("/items/price/{price}")
    public List<Item> getAllByPrice(@PathVariable int price) {
        return service.findItemsByPrice(price);
    }

    @GetMapping("/item/{id}")
    public Item get(@PathVariable UUID id) {
        return service.getItem(id);
    }

    @DeleteMapping("/item/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteItem(id);
    }
}

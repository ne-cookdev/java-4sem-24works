package com.example.lesson16.controller;

import com.example.lesson16.model.Item;
import com.example.lesson16.model.Order;
import com.example.lesson16.service.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImplementation service;

    @PostMapping("/order")
    public void post(@RequestBody Order order) {
        service.addOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getAll() {
        return service.getOrders();
    }

    @GetMapping("/order/orderDate/{orderDate}")
    public List<Order> getAllByOrderDate(@PathVariable int orderDate) {
        return service.findOrdersByOrderDate(orderDate);
    }

    @GetMapping("/order/{id}")
    public List<Order> get(@PathVariable UUID id) {
        return service.getOrder(id);
    }

    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteOrder(id);
    }

    @GetMapping("/order/{id}/items")
    public List<Item> getItemsByOrder(@PathVariable UUID id) {
        return service.getItemsByOrder(id);
    }
}

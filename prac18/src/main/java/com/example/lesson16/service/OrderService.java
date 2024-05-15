package com.example.lesson16.service;

import com.example.lesson16.model.Order;
import com.example.lesson16.model.Item;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    void addOrder(Order order);

    List<Order> getOrders();

    List<Order> getOrder(UUID id);

    void deleteOrder(Order order);

    void deleteOrder(UUID id);

    List<Item> getItemsByOrder(UUID orderId);

    List<Order> findOrderByOrderDate(int orderDate);
}

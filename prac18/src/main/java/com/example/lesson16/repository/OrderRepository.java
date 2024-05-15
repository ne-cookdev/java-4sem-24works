package com.example.lesson16.repository;

import com.example.lesson16.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> getAllById(UUID id);

    List<Order> findAllByOrderDate(int orderDate);
}
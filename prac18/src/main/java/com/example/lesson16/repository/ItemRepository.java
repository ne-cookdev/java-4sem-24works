package com.example.lesson16.repository;

import com.example.lesson16.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    List<Item> findAllById(UUID id);

    List<Item> findAllByName(String name);

    List<Item> findAllByCreationDate(int creationDate);

    List<Item> findAllByPrice(int price);
}
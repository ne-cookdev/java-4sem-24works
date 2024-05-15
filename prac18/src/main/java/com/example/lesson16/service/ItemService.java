package com.example.lesson16.service;

import com.example.lesson16.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    List<Item> getItems();

    Item getItem(UUID id);

    void addItem(Item item);

    void deleteItem(UUID id);

    List<Item> findItemsByName(String name);

    List<Item> findItemsByCreationYear(int creationDate);

    List<Item> findItemsByPrice(int price);
}


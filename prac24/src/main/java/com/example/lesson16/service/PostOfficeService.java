package com.example.lesson16.service;

import com.example.lesson16.model.Departure;
import com.example.lesson16.model.PostOffice;

import java.util.List;
import java.util.UUID;

public interface PostOfficeService {

    void addPostOffice(PostOffice postOffice);

    List<PostOffice> getPostOffices();

    List<PostOffice> getPostOffice(UUID id);

    void deletePostOffice(PostOffice postOffice);

    void deletePostOffice(UUID id);

    List<Departure> getPostOfficesByDeparture(UUID DepartureId);

    List<PostOffice> findPostOfficesByName(String name);
}

package com.example.lesson16.service;

import com.example.lesson16.model.Departure;

import java.util.List;
import java.util.UUID;

public interface DepartureService {
    void addDeparture(Departure departure);

    List<Departure> getDepartures();

    Departure getDeparture(UUID id);

    void deleteDeparture(UUID id);

    List<Departure> findAllByType(String type);

    List<Departure> findDeparturesByDepartureDate(String departureDate);
}


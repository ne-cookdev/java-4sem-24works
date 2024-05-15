package com.example.lesson15.controller;

import com.example.lesson15.model.Departure;
import com.example.lesson15.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DepartureController {
    @Autowired
    private DepartureService service;

    @PostMapping("/departure")
    public void post(@RequestBody Departure departure) {
        service.addDeparture(departure);
    }

    @GetMapping("/departures")
    public List<Departure> getAll() {
        return service.getDepartures();
    }

    @GetMapping("/departure/{id}")
    public Departure get(@PathVariable UUID id) {
        return service.getDeparture(id);
    }

    @DeleteMapping("/departure/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteDeparture(id);
    }
}

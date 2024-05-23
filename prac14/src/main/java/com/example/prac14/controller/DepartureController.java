package com.example.prac14.controller;

import com.example.prac14.Departure;
import com.example.prac14.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartureController {
    @Autowired
    private DepartureService service;

    @PostMapping("/postDepartures")
    public void post(@RequestBody Departure departure) {
        service.add(departure);
    }

    @GetMapping("/getDepartures")
    public List<Departure> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/deleteDepartures")
    public void delete(@RequestBody Departure departure) {
        service.delete(departure);
    }
}

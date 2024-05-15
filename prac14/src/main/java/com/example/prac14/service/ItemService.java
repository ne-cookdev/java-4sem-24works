package com.example.prac14.service;

import com.example.prac14.Departure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private List<Departure> departures;

    public ItemService() {
        departures = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        departures.add(new Departure("Express", 1645));
        departures.add(new Departure("Express", 6615));
        departures.add(new Departure("Sapsan", 46145));
    }

    public void add(Departure departure) {
        departures.add(departure);
    }


    public List<Departure> getAll() {
        return departures;
    }


    public void delete(Departure departure) {
        departures.remove(departure);
    }
}

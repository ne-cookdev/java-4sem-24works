package com.example.prac14.service;

import com.example.prac14.PostOffice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<PostOffice> postOffices;

    public OrderService() {
        postOffices = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        postOffices.add(new PostOffice("E-7001", "Moscow"));
        postOffices.add(new PostOffice("E-7006", "Kaluga"));
        postOffices.add(new PostOffice("S-3900", "SPB"));
    }

    public void addOrder(PostOffice postOffice) {
        postOffices.add(postOffice);
    }

    public List<PostOffice> getOrders() {
        return postOffices;
    }

    public void deleteOrder(PostOffice postOffice) {
        postOffices.remove(postOffice);
    }
}

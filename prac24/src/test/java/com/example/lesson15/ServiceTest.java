package com.example.lesson15;

import com.example.lesson16.model.Departure;
import com.example.lesson16.model.PostOffice;
import com.example.lesson16.repository.DepartureRepository;
import com.example.lesson16.repository.PostOfficeRepository;
import com.example.lesson16.service.DepartureService;
import com.example.lesson16.service.DepartureServiceImplementation;
import com.example.lesson16.service.PostOfficeService;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration
class ServiceTest {
    DepartureService departureService;

    PostOfficeService postOfficeService;

    @MockBean
    private DepartureRepository departureRepository;

    @MockBean
    private PostOfficeRepository postOfficeRepository;

    @Test
    void getDepartures() {
        Departure departure1 = new Departure();
        departure1.setType("Express");
        Departure departure2 = new Departure();
        departure2.setType("Sapsan");

        Assertions.assertEquals(departure1.getType(), "Express");
        Assertions.assertEquals(departure2.getType(), "Sapsan");
    }

    @Test
    void getPosts() {
        PostOffice postOffice = new PostOffice();
        postOffice.setCityName("Moscow");

        Assertions.assertEquals(postOffice.getCityName(), "Moscow");
    }
}
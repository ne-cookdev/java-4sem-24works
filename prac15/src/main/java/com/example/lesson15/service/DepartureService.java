package com.example.lesson15.service;

import com.example.lesson15.model.Departure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class DepartureService {

    @Autowired
    private final SessionFactory sessionFactory;

    public DepartureService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void addDeparture(Departure departure) {
        session.beginTransaction();
        session.saveOrUpdate(departure);
        session.getTransaction().commit();
    }

    public List<Departure> getDepartures() {
        return session.createQuery("SELECT p FROM Departure p", Departure.class).list();
    }

    public Departure getDeparture(UUID id) {
        return session.createQuery("SELECT p FROM Departure p WHERE p.id = '" + id + "'", Departure.class).getSingleResult();
    }

    public void deleteDeparture(UUID id) {

        session.beginTransaction();

        Departure temp = session.load(Departure.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}

package com.example.lesson15.service;

import com.example.lesson15.model.PostOffice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class PostOfficeService {

    @Autowired
    private final SessionFactory sessionFactory;

    public PostOfficeService(SessionFactory sessionFactory) {
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

    public void addPostOffice(PostOffice postOffice) {
        session.beginTransaction();
        session.saveOrUpdate(postOffice);
        session.getTransaction().commit();
    }

    public List<PostOffice> getPostOffice() {
        return session.createQuery("SELECT mn FROM postoffice mn", PostOffice.class).list();
    }

    public List<PostOffice> getPostOffice(UUID id) {
        return session.createQuery("SELECT mn FROM postoffice mn WHERE mn.id ='" + id + "'", PostOffice.class).list();
    }

    public void deletePostOffice(PostOffice postOffice) {
        session.beginTransaction();

        List<PostOffice> query = session.createQuery("SELECT mn FROM postoffice mn WHERE mn.orderDate = '" + postOffice.getName() + "'", PostOffice.class).list();
        for (PostOffice mn : query) {
            session.delete(mn);
        }

        session.getTransaction().commit();
    }

    public void deletePostOffice(UUID id) {
        session.beginTransaction();

        PostOffice temp = session.load(PostOffice.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}

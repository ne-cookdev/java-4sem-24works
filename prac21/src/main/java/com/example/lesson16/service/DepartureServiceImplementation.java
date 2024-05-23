package com.example.lesson16.service;

import com.example.lesson16.model.Departure;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartureServiceImplementation implements DepartureService {
    private static final Logger logger = LoggerFactory.getLogger("application");

    @Autowired
    private final SessionFactory sessionFactory;

    @Autowired
    EmailService serviceSender;

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
        logger.info("addDeparture");
        serviceSender.send("Предмет создан");
        session.beginTransaction();
        session.saveOrUpdate(departure);
        session.getTransaction().commit();
    }

    public List<Departure> getDepartures() {
        logger.info("getDepartures");
        return session.createQuery("SELECT p FROM Departure p", Departure.class).list();
    }

    public Departure getDeparture(UUID id) {
        logger.info("getDeparture");
        return session.createQuery("SELECT p FROM Departure p WHERE p.id = '" + id + "'", Departure.class).getSingleResult();
    }

    public void deleteDeparture(UUID id) {
        logger.info("deleteDeparture");
        serviceSender.send("Предмет удалён");
        session.beginTransaction();

        Departure temp = session.load(Departure.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    @PersistenceContext
    EntityManager em;

    public List<Departure> findAllByType(String type) {
        logger.info("findAllByType");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Departure> cq = cb.createQuery(Departure.class);

        Root<Departure> item = cq.from(Departure.class);
        Predicate namePredicate = cb.equal(item.get("type"), type);
        cq.where(namePredicate);

        TypedQuery<Departure> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Departure> findDeparturesByDepartureDate(String departureDate) {
        logger.info("findDeparturesByDepartureDate");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Departure> cq = cb.createQuery(Departure.class);

        Root<Departure> item = cq.from(Departure.class);
        Predicate creationDatePredicate = cb.equal(item.get("creationDate"), departureDate);
        cq.where(creationDatePredicate);

        TypedQuery<Departure> query = em.createQuery(cq);
        return query.getResultList();
    }
}

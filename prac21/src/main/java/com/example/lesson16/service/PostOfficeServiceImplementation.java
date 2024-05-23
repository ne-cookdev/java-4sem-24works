package com.example.lesson16.service;

import com.example.lesson16.model.PostOffice;
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
public class PostOfficeServiceImplementation {
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

    public void addPostOffice(PostOffice postOffice) {
        logger.info("addPostOffice");
        serviceSender.send("Заказ создан");
        session.beginTransaction();
        session.saveOrUpdate(postOffice);
        session.getTransaction().commit();
    }

    public List<PostOffice> getPostOffice() {
        logger.info("getPostOffice");
        return session.createQuery("SELECT mn FROM postoffice mn", PostOffice.class).list();
    }

    public List<PostOffice> getPostOffice(UUID id) {
        logger.info("getPostOffice");
        return session.createQuery("SELECT mn FROM postoffice mn WHERE mn.id ='" + id + "'", PostOffice.class).list();
    }

    public void deletePostOffice(PostOffice postOffice) {
        logger.info("deletePostOffice");
        serviceSender.send("Заказ удалён");
        session.beginTransaction();

        List<PostOffice> query = session.createQuery("SELECT mn FROM postoffice mn WHERE mn.orderDate = '" + postOffice.getName() + "'", PostOffice.class).list();
        for (PostOffice mn : query) {
            session.delete(mn);
        }

        session.getTransaction().commit();
    }

    public void deletePostOffice(UUID id) {
        logger.info("deletePostOffice");
        session.beginTransaction();

        PostOffice temp = session.load(PostOffice.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    public List<Departure> getPostOfficesByDeparture(UUID DepartureId) {
        logger.info("getPostOfficesByDeparture");
        System.out.println("SELECT m FROM Departure m WHERE m.id = '" + DepartureId.toString() + "'");
        return session.createQuery("SELECT m FROM Postoffice m WHERE m.id = '" + DepartureId.toString() + "'", PostOffice.class)
                .getSingleResult().getItems();
    }

    @PersistenceContext
    EntityManager em;

    public List<PostOffice> findPostOfficesByName(String name) {
        logger.info("findPostOfficesByName");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PostOffice> cq = cb.createQuery(PostOffice.class);

        Root<PostOffice> postOffice = cq.from(PostOffice.class);
        Predicate namePredicate = cb.equal(postOffice.get("name"), name);
        cq.where(namePredicate);

        TypedQuery<PostOffice> query = em.createQuery(cq);
        return query.getResultList();
    }
}

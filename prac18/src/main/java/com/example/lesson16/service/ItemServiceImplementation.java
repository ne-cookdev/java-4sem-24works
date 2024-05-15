package com.example.lesson16.service;

import com.example.lesson16.model.Item;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImplementation {

    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void addItem(Item item) {
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
    }

    public List<Item> getItems() {
        return session.createQuery("select p from Item p", Item.class).list();
    }

    public Item getItem(UUID id) {
        return session.createQuery("select p from Item p where p.id = '" + id + "'", Item.class).getSingleResult();
    }

    public void deleteItem(UUID id) {

        session.beginTransaction();

        Item temp = session.load(Item.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    @PersistenceContext
    EntityManager em;

    public List<Item> findItemsByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);

        Root<Item> item = cq.from(Item.class);
        Predicate namePredicate = cb.equal(item.get("name"), name);
        cq.where(namePredicate);

        TypedQuery<Item> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Item> findItemsByCreationDate(int creationDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);

        Root<Item> item = cq.from(Item.class);
        Predicate creationDatePredicate = cb.equal(item.get("creationDate"), creationDate);
        cq.where(creationDatePredicate);

        TypedQuery<Item> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Item> findItemsByPrice(int price) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);

        Root<Item> item = cq.from(Item.class);
        Predicate pricePredicate = cb.equal(item.get("price"), price);
        cq.where(pricePredicate);

        TypedQuery<Item> query = em.createQuery(cq);
        return query.getResultList();
    }
}

package com.example.lesson16.service;

import com.example.lesson16.model.Order;
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
public class OrderServiceImplementation {

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

    public void addOrder(Order order) {
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
    }

    public List<Order> getOrders() {
        return session.createQuery("select mn from Order mn", Order.class).list();
    }

    public List<Order> getOrder(UUID id) {
        return session.createQuery("select mn from Order mn where mn.id ='" + id + "'", Order.class).list();
    }

    public void deleteOrder(Order order) {
        session.beginTransaction();

        List<Order> query = session.createQuery("select mn from Order mn where mn.orderDate = '" + order.getOrderDate() + "'", Order.class).list();
        for (Order mn : query) {
            session.delete(mn);
        }

        session.getTransaction().commit();
    }

    public void deleteOrder(UUID id) {
        session.beginTransaction();

        Order temp = session.load(Order.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    public List<Item> getItemsByOrder(UUID orderId) {
        System.out.println("select m from manufacture m where m.id = '" + orderId.toString() + "'");
        return session.createQuery("select m from Order m where m.id = '" + orderId.toString() + "'", Order.class)
                .getSingleResult().getItems();
    }

    @PersistenceContext
    EntityManager em;

    public List<Order> findOrdersByOrderDate(int orderDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);

        Root<Order> manufacture = cq.from(Order.class);
        Predicate namePredicate = cb.equal(manufacture.get("orderDate"), orderDate);
        cq.where(namePredicate);

        TypedQuery<Order> query = em.createQuery(cq);
        return query.getResultList();
    }
}

package com.example.demo.dao.impl;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory sessionFactory;
    private Session currentSession;

    public CustomerDAOImpl() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

    }

    @Override
    public List<Customer> getCustomers() {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName", Customer.class);

        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.persist(theCustomer);
        currentSession.getTransaction().commit();
    }
}

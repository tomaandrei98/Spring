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

    public CustomerDAOImpl() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    @Override
    public List<Customer> getCustomers() {
        Query<Customer> theQuery;
        List<Customer> resultList;
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
            resultList = theQuery.getResultList();
        }

        return resultList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            currentSession.saveOrUpdate(theCustomer);
            currentSession.getTransaction().commit();
        }
    }

    @Override
    public Customer getCustomer(int theId) {
        Customer theCustomer;
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            theCustomer = currentSession.get(Customer.class, theId);
        }
        return theCustomer;
    }
}

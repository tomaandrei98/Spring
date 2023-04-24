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

    @Override
    public void deleteCustomer(int theId) {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            Query theQuery = currentSession.createQuery("delete from Customer where id = :customerId");
            theQuery.setParameter("customerId", theId);
            theQuery.executeUpdate();
        }
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        Query<Customer> theQuery = null;
        List<Customer> customers = null;
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();

            if (theSearchName != null && theSearchName.trim().length() > 0) {
                theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName " +
                        "or lower(lastName) like :theName", Customer.class);
                theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
            } else {
                theQuery = currentSession.createQuery("from Customer", Customer.class);
            }
            customers = theQuery.getResultList();
        }
        return customers;
    }
}

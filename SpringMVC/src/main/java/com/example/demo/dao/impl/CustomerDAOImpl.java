package com.example.demo.dao.impl;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Query<Customer> theQuery =
                session.createQuery("from Customer", Customer.class);

        return theQuery.getResultList();
    }
}

package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}

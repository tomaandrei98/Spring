package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

}

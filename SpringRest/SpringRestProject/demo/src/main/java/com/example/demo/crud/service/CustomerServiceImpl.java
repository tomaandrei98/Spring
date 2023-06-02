package com.example.demo.crud.service;

import com.example.demo.crud.dao.CustomerDAO;
import com.example.demo.crud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAO.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        return customerDAO.findById(theId).orElse(null);
    }

    @Override
    public void deleteCustomer(int theId) {
        customerDAO.deleteById(theId);
    }
}

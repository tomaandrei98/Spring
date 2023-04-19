package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerDAO.getCustomers();

        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}

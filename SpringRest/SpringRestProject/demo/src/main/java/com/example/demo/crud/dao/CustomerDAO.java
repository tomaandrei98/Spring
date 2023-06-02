package com.example.demo.crud.dao;

import com.example.demo.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
}

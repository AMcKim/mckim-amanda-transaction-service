package com.example.demo.repository;

import com.example.demo.models.Customer;

import java.text.ParseException;
import java.util.List;

public interface CustomerRepository {

    public List<Customer> getCustomers() throws ParseException;
}

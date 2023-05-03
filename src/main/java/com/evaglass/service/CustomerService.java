package com.evaglass.service;

import com.evaglass.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
    Customer getCustomerById(Integer id);

    void deleteCustomerById(Integer id);
}

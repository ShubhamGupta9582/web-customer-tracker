package com.crm.app.services;

import com.crm.app.entities.Customer;

import java.util.List;

/**
 * Created by Shubham Gupta on Wed, 21/11/18.
 */
public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String name);
}

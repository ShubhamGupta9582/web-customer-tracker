package com.crm.app.dao;

import com.crm.app.entities.Customer;

import java.util.List;

/**
 * Created by Shubham Gupta on Tue, 20/11/18.
 */
public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String name);
}

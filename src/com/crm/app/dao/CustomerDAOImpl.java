package com.crm.app.dao;

import com.crm.app.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shubham Gupta on Tue, 20/11/18.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Customer> getCustomers() {

        Session session = factory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = factory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String name) {
        Session session = factory.getCurrentSession();
        Query<Customer> query = null;
        if (name != null && name.trim().length() > 0) {
            query = session.createQuery("from Customer where lower(firstName) LIKE :customerName OR lower(lastName) LIKE :customerName", Customer.class);
            query.setParameter("customerName",  "%" + name.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer", Customer.class);
        }
        List<Customer> customers = query.getResultList();
        return customers;
    }
}

package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.database.HibernatePropertiesUtil;
import com.hillel.database.HibernateUtil;
import com.hillel.database.HibernateXMLUtil;
import com.hillel.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public List<Customer> findAllCustomers() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Customer").list();
        }
    }

    public Customer findById(Integer id) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.byId(Customer.class).getReference(id);
        }
    }

    public void save(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(customer);
            transaction.commit();
        }
    }

    public void delete(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(customer);
            transaction.commit();
        }
    }

    public void update(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(customer);
            transaction.commit();
        }
    }
}

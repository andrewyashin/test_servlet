package com.hillel.dao;

import com.hillel.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    private static final String FIND_ALL_CUSTOMERS = "SELECT * FROM customers";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Customer> customerRowMapper;

    public List<Customer> findAllCustomers() {
        return jdbcTemplate.query(FIND_ALL_CUSTOMERS, customerRowMapper);
    }

//    public List<Customer> findCustomersWhereSurname(String surname) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//            Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
//            criteriaQuery.select(customerRoot).where(criteriaBuilder.equal(customerRoot.get("surname"), surname));
//            return session.createQuery(criteriaQuery).getResultList();
//        }
//    }

//    public Customer findById(Integer id) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.byId(Customer.class).getReference(id);
//        }
//    }
//
//    public void save(Customer customer) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.save(customer);
//            transaction.commit();
//        }
//    }

//    public void delete(Customer customer) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.delete(customer);
//            transaction.commit();
//        }
//    }

//    public void update(Customer customer) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.update(customer);
//            transaction.commit();
//        }
//    }
}

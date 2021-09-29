package com.hillel.dao;

import com.hillel.database.HibernatePropertiesUtil;
import com.hillel.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDao {

    public static final String FROM_CUSTOMER_WHERE_SURNAME_SURNAME = "FROM Customer where surname = :surname";
    public static final String SURNAME = "surname";

    public List<Customer> findAllCustomers() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Customer").list();
        }
    }

//    public List<Customer> findCustomersWhereSurname(String surname) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM Customer where surname = :surname")
//                    .setParameter(SURNAME, surname).list();
//        }
//    }

//    public List<Customer> findCustomersWhereSurname(String surname) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.createNamedQuery("findCustomersBySurname")
//                    .setParameter(SURNAME, surname).list();
//        }
//    }

//    public List<Customer> findCustomersWhereSurname(String surname) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//            Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
//            criteriaQuery.select(customerRoot).where(criteriaBuilder.equal(customerRoot.get("surname"), surname));
//            return session.createQuery(criteriaQuery).getResultList();
//        }
//    }

    public Customer findById(Integer id) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.byId(Customer.class).getReference(id);
        }
    }

    public void save(Customer customer) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(customer);
            transaction.commit();
        }
    }

    public void delete(Customer customer) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(customer);
            transaction.commit();
        }
    }

    public void update(Customer customer) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(customer);
            transaction.commit();
        }
    }
}

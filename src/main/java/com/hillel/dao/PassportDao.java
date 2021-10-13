package com.hillel.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class PassportDao {

    @Autowired
    private EntityManager entityManager;

//    public List<Passport> findAllPassports() {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM Passport").list();
//        }
//    }
//
//    public Passport findById(Integer id) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.byId(Passport.class).getReference(id);
//        }
//    }
//
//    public void save(Passport passport) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.save(passport);
//            transaction.commit();
//        }
//    }
//
//    public void delete(Passport passport) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.delete(passport);
//            transaction.commit();
//        }
//    }
//
//    public void update(Passport passport) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.update(passport);
//            transaction.commit();
//        }
//    }
}

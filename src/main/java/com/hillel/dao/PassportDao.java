package com.hillel.dao;

import com.hillel.database.HibernatePropertiesUtil;
import com.hillel.entity.Passport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PassportDao {
    public List<Passport> findAllPassports() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Passport").list();
        }
    }

    public Passport findById(Integer id) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.byId(Passport.class).getReference(id);
        }
    }

    public void save(Passport passport) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(passport);
            transaction.commit();
        }
    }

    public void delete(Passport passport) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(passport);
            transaction.commit();
        }
    }

    public void update(Passport passport) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(passport);
            transaction.commit();
        }
    }
}

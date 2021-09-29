package com.hillel.dao;

import com.hillel.database.HibernatePropertiesUtil;
import com.hillel.entity.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDao {
    public List<Role> findAllRoles() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Role").list();
        }
    }

    public Role findById(Integer id) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.byId(Role.class).getReference(id);
        }
    }

    public void save(Role role) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(role);
            transaction.commit();
        }
    }

    public void delete(Role role) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(role);
            transaction.commit();
        }
    }

    public void update(Role role) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(role);
            transaction.commit();
        }
    }
}

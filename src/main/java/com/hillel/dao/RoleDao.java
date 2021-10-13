package com.hillel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDao {

    @Autowired
    private EntityManager entityManager;

//    public List<Role> findAllRoles() {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM Role").list();
//        }
//    }
//
//    public Role findById(Integer id) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            return session.byId(Role.class).getReference(id);
//        }
//    }
//
//    public void save(Role role) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.save(role);
//            transaction.commit();
//        }
//    }
//
//    public void delete(Role role) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.delete(role);
//            transaction.commit();
//        }
//    }
//
//    public void update(Role role) {
//        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.update(role);
//            transaction.commit();
//        }
//    }
}

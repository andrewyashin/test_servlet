package com.hillel.dao;

import com.hillel.database.HibernatePropertiesUtil;
import com.hillel.entity.House;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HouseDao {
    public List<House> findAllHouses() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM House", House.class).list();
        }
    }

    public List<House> findHousesByAddress(String address) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM House WHERE address = :address", House.class)
                    .setParameter("address", address)
                    .list();
        }
    }

    public House findById(int id) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<House> criteriaQuery = criteriaBuilder.createQuery(House.class);
            Root<House> houseRoot = criteriaQuery.from(House.class);
            criteriaQuery.select(houseRoot).where(criteriaBuilder.equal(houseRoot.get("id"), id));
            return session.createQuery(criteriaQuery).getSingleResult();
        }
    }

    public void save(House house) {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(house);
            transaction.commit();
        }
    }
}

package com.hillel.dao;

import com.hillel.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HouseDao {

    @Autowired
    private EntityManager entityManager;


    public List<House> findAllHouses() {
        return entityManager.createQuery("FROM House", House.class).getResultList();
    }

//    public List<House> findHousesByAddress(String address) {
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("FROM House WHERE address = :address", House.class)
//                    .setParameter("address", address)
//                    .list();
//        }
//    }

//    public House findById(int id) {
//        try (Session session = sessionFactory.openSession()) {
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<House> criteriaQuery = criteriaBuilder.createQuery(House.class);
//            Root<House> houseRoot = criteriaQuery.from(House.class);
//            criteriaQuery.select(houseRoot).where(criteriaBuilder.equal(houseRoot.get("id"), id));
//            return session.createQuery(criteriaQuery).getSingleResult();
//        }
//    }

//    public void save(House house) {
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.save(house);
//            transaction.commit();
//        }
//    }
}

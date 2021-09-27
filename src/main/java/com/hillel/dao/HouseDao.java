package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.database.HibernatePropertiesUtil;
import com.hillel.database.HibernateUtil;
import com.hillel.entity.Customer;
import com.hillel.entity.House;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDao {
    public List<House> findAllHouses() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM House").list();
        }
    }

    public void save(House house) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(house);
            transaction.commit();
        }
    }
}

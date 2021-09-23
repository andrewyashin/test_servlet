package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.database.HibernateUtil;
import com.hillel.entity.Customer;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id=?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id=?";
    private static final String UPDATE =
            "UPDATE customers SET name=?, surname=?, email=?, age=?, password=? WHERE id=?";

    public List<Customer> findAllCustomers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        }
    }

    public Customer findById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(CUSTOMER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));

                return customer;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public void save(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.save(customer);
        }
    }

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void update(Customer customer) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getAge());
            statement.setString(5, customer.getPassword());
            statement.setInt(6, customer.getId());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

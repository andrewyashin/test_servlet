package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String INSERT =
            "INSERT INTO customers (name,surname,email,age,password) VALUES (?,?,?,?,?)";
    private static final String FIND_ALL = "SELECT * FROM customers ORDER BY id";
    private static final String CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id=?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id=?";
    private static final String UPDATE =
            "UPDATE customers SET name=?, surname=?, email=?, age=?, password=? WHERE id=?";

    public List<Customer> findAllCustomers() {
        List<Customer> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));

                resultList.add(customer);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
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
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getAge());
            statement.setString(5, customer.getPassword());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
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

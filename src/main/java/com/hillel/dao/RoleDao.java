package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    private static final String FIND_ALL = "SELECT * FROM roles ORDER BY id";

    public List<Role> findAllRoles() {
        List<Role> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                resultList.add(role);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }
}

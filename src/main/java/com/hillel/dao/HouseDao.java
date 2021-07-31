package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Customer;
import com.hillel.entity.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDao {
    private static final String FIND_ALL = "SELECT * FROM houses ORDER BY id";

    public List<House> findAllHouses() {
        List<House> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                House house = new House();
                house.setAddress(resultSet.getString("address"));
                house.setOwnerId(resultSet.getInt("owner_id"));
                resultList.add(house);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }
}

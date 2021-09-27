package com.hillel.service;

import com.hillel.dao.CustomerDao;
import com.hillel.dao.HouseDao;
import com.hillel.dto.CustomerDto;
import com.hillel.dto.HouseDto;
import com.hillel.entity.Customer;
import com.hillel.entity.House;

import java.util.ArrayList;
import java.util.List;

public class HouseService {
    private final HouseDao houseDao;

    public HouseService() {
        houseDao = new HouseDao();
    }

    public List<HouseDto> findAllHouses() {
        List<House> houses = houseDao.findAllHouses();
        List<HouseDto> result = new ArrayList<>();

        for (House house: houses) {
            HouseDto dto = new HouseDto();
            dto.setAddress(house.getAddress());
//            dto.setOwnerId(house.getOwnerId());
            result.add(dto);
        }

        return result;
    }

}

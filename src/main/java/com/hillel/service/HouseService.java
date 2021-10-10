package com.hillel.service;

import com.hillel.dao.HouseDao;
import com.hillel.dto.HouseDto;
import com.hillel.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseDao houseDao;

    public List<HouseDto> findAllHouses() {
        List<House> houses = houseDao.findAllHouses();
        List<HouseDto> result = new ArrayList<>();

        for (House house : houses) {
            HouseDto dto = new HouseDto();
            dto.setAddress(house.getAddress());
//            dto.setOwnerId(house.getOwnerId());
            result.add(dto);
        }

        return result;
    }

}

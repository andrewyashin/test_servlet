package com.hillel.controller;

import com.hillel.dto.HouseDto;
import com.hillel.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/app/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    public List<HouseDto> houses() {
        return houseService.findAllHouses();
    }

}

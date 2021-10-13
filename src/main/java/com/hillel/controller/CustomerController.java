package com.hillel.controller;

import com.hillel.dto.CustomerDto;
import com.hillel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDto> customers(ModelMap modelMap) {
        return customerService.findAllCustomers();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByParam(@RequestParam Integer id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public List<CustomerDto> save(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
        return customerService.findAllCustomers();
    }
}

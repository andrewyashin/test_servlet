package com.hillel.service;

import com.hillel.dao.CustomerDao;
import com.hillel.dto.CustomerDto;
import com.hillel.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerDao.findAllCustomers();
        List<CustomerDto> result = new ArrayList<>();

        for (Customer customer: customers) {
            CustomerDto dto = new CustomerDto();
            dto.setEmail(customer.getEmail());
            dto.setId(customer.getId());
            dto.setName(customer.getName());
            dto.setSurname(customer.getSurname());
            result.add(dto);
        }

        return result;
    }
}

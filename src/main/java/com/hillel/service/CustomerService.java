package com.hillel.service;

import com.hillel.dto.CustomerDto;
import com.hillel.entity.Customer;
import com.hillel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> result = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDto dto = new CustomerDto();
            dto.setEmail(customer.getEmail());
            dto.setId(customer.getId());
            dto.setName(customer.getName());
            dto.setSurname(customer.getSurname());
            result.add(dto);
        }

        return result;
    }

    public void save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setAge(18);
        customer.setPassword(UUID.randomUUID().toString().substring(0, 20));

        customerRepository.save(customer);
    }

    public void delete(int id) {
        Customer customer = customerRepository.findById(Integer.toUnsignedLong(id)).get();
        if (customer != null) {
            customerRepository.delete(customer);
        } else {
            System.out.println("Customer with id has been already deleted - " + id);
//            logger.warn("Customer with id {} has been already deleted", id);
        }
    }
}

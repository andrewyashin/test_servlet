package com.hillel;

import com.hillel.config.DatabaseConfig;
import com.hillel.repository.CustomerRepository;
import com.hillel.service.CustomerService;
import com.hillel.service.HouseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        CustomerService customerService = (CustomerService) context.getBean("customerService");
        HouseService houseService = (HouseService) context.getBean("houseService");
        CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");

        System.out.println(customerService.findAllCustomers());
        System.out.println(houseService.findAllHouses());
        System.out.println(customerRepository.findAll());
        System.out.println(customerRepository.findById(74L));
    }
}

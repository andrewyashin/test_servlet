package com.hillel;

import com.hillel.dao.CustomerDao;
import com.hillel.dao.HouseDao;
import com.hillel.entity.Customer;
import com.hillel.entity.House;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        HouseDao houseDao = new HouseDao();

        Customer customer = new Customer();
        customer.setName("Test");
        customer.setSurname("Test");
        customer.setEmail(UUID.randomUUID().toString().substring(0,20));
        customer.setAge(0);
        customer.setPassword("qsd");

        House house = new House();
        house.setAddress(UUID.randomUUID().toString().substring(0,10));
        house.setOwner(customer);

        System.out.println("Customer id before saving - " + customer.getId());
        customerDao.save(customer);
        System.out.println("Customer id after saving - " + customer.getId());

        customerDao.findAllCustomers().forEach(System.out::println);

//        System.out.println("Delete customer " + customer.getId());
//        customerDao.delete(customer);

//        customerDao.findAllCustomers().forEach(System.out::println);

        houseDao.save(house);


        customerDao.findAllCustomers().forEach(System.out::println);


    }
}

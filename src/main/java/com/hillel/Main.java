package com.hillel;

import com.hillel.dao.CustomerDao;
import com.hillel.dao.RoleDao;
import com.hillel.entity.Customer;
import com.hillel.entity.House;
import com.hillel.entity.Passport;

import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        RoleDao roleDao = new RoleDao();

//        Customer customer = new Customer();
//        customer.setName("Test");
//        customer.setSurname("Test");
//        customer.setEmail(UUID.randomUUID().toString().substring(0,20));
//        customer.setAge(0);
//        customer.setPassword("qsd");
//
//
//        System.out.println("Customer id before saving - " + customer.getId());
//        customerDao.save(customer);
//        System.out.println("Customer id after saving - " + customer.getId());
//
//        customerDao.findAllCustomers().forEach(System.out::println);

//        System.out.println("Delete customer " + customer.getId());
//        customerDao.delete(customer);

//        customerDao.findAllCustomers().forEach(System.out::println);

//        houseDao.save(house);
//
//
//        customerDao.findAllCustomers().forEach(System.out::println);

//        customerDao.findCustomersWhereSurname("Test").forEach(System.out::println);


//        houseDao.findAllHouses().forEach(System.out::println);
//
//        System.out.println("Find by asdasdas");
//        System.out.println(houseDao.findHousesByAddress("asdasdas"));

        Customer customer = new Customer();
        customer.setName("Test");
        customer.setSurname("Test");
        customer.setEmail(UUID.randomUUID().toString().substring(0, 20));
        customer.setAge(0);
        customer.setPassword("qsd");

        Passport passport = new Passport();
        passport.setData("data");

        House house = new House();
        house.setAddress(UUID.randomUUID().toString().substring(0, 20));

        customer.setRoles(new HashSet<>(roleDao.findAllRoles()));
        customer.setPassport(passport);
        customer.setHouses(Collections.singleton(house));

        customerDao.save(customer);

        System.out.println(customer);
    }
}

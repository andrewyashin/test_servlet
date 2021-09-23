package com.hillel;

import com.hillel.dao.CustomerDao;
import com.hillel.entity.Customer;

public class Main {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();

        Customer customer = new Customer();
        customer.setEmail("asdad");
        customer.setAge(0);

        customerDao.save(customer);

        customerDao.findAllCustomers().forEach(System.out::println);
    }
}

package com.hillel.entity;


import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String password;
}

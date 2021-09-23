package com.hillel.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private int age;
    private String password;


    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }
}

package com.example.C868CapstoneProject.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Admin")
public class Admin extends Person {

    public Admin() {
    }

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
    public Admin(String name, String email, String password, String url) {
        super(name, email, password, url);
    }
}

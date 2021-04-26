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

    public Admin(String name, String username, String password) {
        super(name, username, password);
    }
}

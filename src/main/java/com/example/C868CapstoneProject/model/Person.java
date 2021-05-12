package com.example.C868CapstoneProject.model;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="unclassified")
public class Person {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "person_id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "email",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "url",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String url;

    @Column(
            name = "activated",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private boolean activated;

    @OneToMany
    private Set<Charge> charges;

    @OneToMany
    private Set<Book> books;

    public Person() {
    }

    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.activated = false;
    }

    public Person(String name, String email, String password, String url) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.url = url;
        this.activated = false;
    }

    public Long getUserID() {
        return id;
    }

    public void setUserID(Long userID) {
        this.id = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userID=" + id + '\'' +
                "name=" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", activated=" + activated +
                '}';
    }
}

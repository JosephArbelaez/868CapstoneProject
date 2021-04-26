package com.example.C868CapstoneProject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="patron")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Patron")
public class Patron extends Person {

    @Column(
            name = "cardNumber"
    )
    Long cardNumber;

    @OneToMany(mappedBy="patron")
    private Set<Book> books;

    @OneToMany(mappedBy="patron")
    private Set<Charge> charges;

    public Patron() {
    }

    public Patron(String name, String username, String password, Long cardNumber) {
        super(name, username, password);
        this.cardNumber = cardNumber;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "cardNumber=" + cardNumber +
                '}';
    }
}

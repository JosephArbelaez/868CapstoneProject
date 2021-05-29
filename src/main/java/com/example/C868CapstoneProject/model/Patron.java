package com.example.C868CapstoneProject.model;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Patron")
public class Patron extends Person {

    @Column(
            name = "cardNumber"
    )
    Long cardNumber;

    public Patron() {
    }

    public Patron(String name, String email, String password, Long cardNumber) {
        super(name, email, password);
        this.cardNumber = cardNumber;
    }

    public Patron(String name, String email, String password, String url, Long cardNumber) {
        super(name, email, password, url);
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

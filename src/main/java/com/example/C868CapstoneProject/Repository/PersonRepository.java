package com.example.C868CapstoneProject.Repository;

import com.example.C868CapstoneProject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

    @Query("SELECT p FROM Person p WHERE type = 'Admin'")
    List<Admin> findAdmins();

    @Query("SELECT p FROM Person p WHERE type = 'Patron'")
    List<Patron> findPatrons();

    @Query(value = "SELECT card_Number from person", nativeQuery = true)
    List<Long> getCardNumbers();

    @Query(value = "SELECT person_id from person where card_number = ?1", nativeQuery = true)
    Long getPersonByCardNumber(Long cardNumber);
}

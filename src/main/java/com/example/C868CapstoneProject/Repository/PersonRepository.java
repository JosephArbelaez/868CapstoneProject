package com.example.C868CapstoneProject.Repository;

import com.example.C868CapstoneProject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

    @Query("SELECT p FROM Person p WHERE type = 'Admin'")
    List<Admin> findAdmins();

    @Query("SELECT p FROM Person p WHERE type = 'Patron'")
    List<Patron> findPatrons();

    @Query(value = "SELECT card_Number from person", nativeQuery = true)
    List<Long> getCardNumbers();

    @Query(value = "UPDATE person SET activated = true WHERE id = ?1", nativeQuery = true)
    void registerPersonByID(Long personID);

    @Query(value = "SELECT id from person where card_number = ?1", nativeQuery = true)
    int getPersonByCardNumber(Long cardNumber);
}

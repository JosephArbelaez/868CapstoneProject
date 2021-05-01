package com.example.C868CapstoneProject.Repository;

import com.example.C868CapstoneProject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

    @Query(value = "SELECT type from person WHERE id=?1", nativeQuery = true)
    String findByType(Long id);

    @Query(value = "SELECT card_Number from person", nativeQuery = true)
    List<Long> getCardNumbers();

    @Query(value = "UPDATE person SET activated = true WHERE id = ?1", nativeQuery = true)
    void registerPersonByID(Long personID);
}

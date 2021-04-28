package com.example.C868CapstoneProject.Repository;

import com.example.C868CapstoneProject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);

    @Query(value = "SELECT type from person WHERE id=?1", nativeQuery = true)
    String findByType(Long id);
}

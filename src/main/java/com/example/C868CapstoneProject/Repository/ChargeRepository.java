package com.example.C868CapstoneProject.Repository;

import com.example.C868CapstoneProject.model.Charge;
import com.example.C868CapstoneProject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge, Long> {


}

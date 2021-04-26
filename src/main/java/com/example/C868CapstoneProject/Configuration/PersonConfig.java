package com.example.C868CapstoneProject.Configuration;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.Repository.PersonRepository;
import com.example.C868CapstoneProject.model.Admin;
import com.example.C868CapstoneProject.model.Book;
import com.example.C868CapstoneProject.model.Patron;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner runner (PersonRepository repository) {
        return args -> {
            Admin a = new Admin(
                    "Sally Rutherfield",
                    "srut",
                    "password"
            );
            Patron b = new Patron(
                    "Francis Freedmont",
                    "Ffreed",
                    "password",
                    1234567L
            );

            repository.save(a);
            repository.save(b);
        };
    }
}
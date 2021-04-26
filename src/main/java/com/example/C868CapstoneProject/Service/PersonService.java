package com.example.C868CapstoneProject.Service;

import com.example.C868CapstoneProject.Repository.PersonRepository;
import com.example.C868CapstoneProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @Transactional
    public void postPerson(Person person, String type, Long cardNumber) {
        Optional<Person> personOptional = personRepository.findById(person.getUserID());

        if (personOptional.isPresent()) {
            throw new IllegalStateException("Person is present");
        } else {
            if (type.equals("admin")) {
                Admin a = new Admin(person.getName(), person.getUsername(), person.getPassword());
                personRepository.save(a);
            } else if (type.equals("patron")) {
                Patron b = new Patron(person.getName(), person.getUsername(), person.getPassword(), cardNumber);
                personRepository.save(b);
            }
        }
    }

    public void deletePerson(Long personID) {
        boolean exists = personRepository.existsById(personID);

        if(!exists) {
            throw new IllegalStateException("Person " + personID + " does not exist.");
        }

        personRepository.deleteById(personID);
    }

    @Transactional
    public void updatePerson(Long personID, String name ,String username, String password, Long cardnumber) {
        Person person = personRepository.findById(personID).orElseThrow(
                () -> new IllegalStateException(
                        "Person " +
                                personID +
                                " does not exist."));

        System.out.println(person.getClass());

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(person.getName(), name)) {
            person.setName(name);
        }

        if (username != null &&
                username.length() > 0 &&
                !Objects.equals(person.getUsername(), username)) {
            person.setUsername(username);
        }

        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(person.getPassword(), password)) {
            person.setPassword(password);
        }
        if (cardnumber != null &&
                cardnumber != 0) {
            Patron p = (Patron) person;
            p.setCardNumber(cardnumber);
        }
    }

    @Transactional
    public void updateAdmin(Long personID,String username, String password) {
        Patron person = (Patron) personRepository.findById(personID).orElseThrow(
                () -> new IllegalStateException (
                        "Person " +
                                personID +
                                " does not exist."));

        if (username != null &&
                username.length() > 0 &&
                !Objects.equals(person.getUsername(), username)) {
            person.setUsername(username);
        }

        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(person.getPassword(), password)) {
            person.setPassword(password);
        }
    }

    public Person getPersonByID(Long personID) {
        return personRepository.findById(personID).get();
    }
}

package com.example.C868CapstoneProject.Service;

import com.example.C868CapstoneProject.Repository.PersonRepository;
import com.example.C868CapstoneProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.sql.SQLException;
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
    @Autowired EmailService emailService;

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
                Admin a = new Admin(person.getName(), person.getEmail(), person.getPassword());
                personRepository.save(a);
                email(a);
            } else if (type.equals("patron")) {
                Patron b = new Patron(person.getName(), person.getEmail(), person.getPassword(), cardNumber);
                personRepository.save(b);
                email(b);
            }

        }
    }
    public void email(Person person) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setTo(person.getEmail());
        mailMessage.setFrom("josepharbelaezwalmart@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8080/api/v1/person/confirm/" + personRepository.findByEmail(person.getEmail()).getUserID());
        emailService.sendEmail(mailMessage);
    }
    public void deletePerson(Long personID) {
        boolean exists = personRepository.existsById(personID);

        if(!exists) {
            throw new IllegalStateException("Person " + personID + " does not exist.");
        }

        personRepository.deleteById(personID);
    }

    @Transactional
    public void updatePerson(Long personID, Person person, Long cardnumber) {
        Person personCheck = personRepository.findById(personID).orElseThrow(
                () -> new IllegalStateException(
                        "Person " +
                                personID +
                                " does not exist."));

        System.out.println(person.getClass());

        if (person.getName() != null &&
                person.getName().length() > 0 &&
                !Objects.equals(personCheck.getName(), person.getName())) {
            personCheck.setName(person.getName());
        }

        if (person.getEmail() != null &&
                person.getEmail() .length() > 0 &&
                !Objects.equals(personCheck.getEmail(), person.getEmail() )) {
            personCheck.setEmail(person.getEmail() );
        }

        if (person.getPassword() != null &&
                person.getPassword().length() > 0 &&
                !Objects.equals(personCheck.getPassword(), person.getPassword())) {
            personCheck.setPassword(person.getPassword());
        }
        if (cardnumber != null &&
                cardnumber != 0) {
            Patron p = (Patron) personCheck;
            p.setCardNumber(cardnumber);
        }
    }

    @Transactional
    public void updateAdmin(Long personID,String email, String password) {
        Patron person = (Patron) personRepository.findById(personID).orElseThrow(
                () -> new IllegalStateException (
                        "Person " +
                                personID +
                                " does not exist."));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(person.getName(), email)) {
            person.setEmail(email);
        }

        if (password != null &&
                password.length() > 0 &&
                password.length() > 0 &&
                !Objects.equals(person.getPassword(), password)) {
            person.setPassword(password);
        }
    }

    public Person getPersonByID(Long personID) {
        return personRepository.findById(personID).get();
    }

    public Person login(String email, String password) {
        try {
            return personRepository.findByEmail(email);
        } catch(Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            return null;
        }
    }

    public List<Long> getCardNumbers() {
        return personRepository.getCardNumbers();
    }

    public void registerPerson(Long personID) {
        try {
            personRepository.registerPersonByID(personID);
        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.valueOf(302), "Registration Successful");
        }
    }

    public int getPersonByCardNumber(Long cardNumber) {
        return personRepository.getPersonByCardNumber(cardNumber);
    }
}

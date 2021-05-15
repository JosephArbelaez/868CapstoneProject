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

    @Transactional
    public void postPatron(Patron patron) {
        Optional<Person> patronOptional = personRepository.findById(patron.getUserID());

        if (patronOptional.isPresent()) {
            throw new IllegalStateException("Person is present");
        } else {
            personRepository.save(patron);
            email(patron);
        }
    }

    @Transactional
    public void postAdmin(Admin admin) {
        Optional<Person> patronOptional = personRepository.findById(admin.getUserID());

        if (patronOptional.isPresent()) {
            throw new IllegalStateException("Person is present");
        } else {
            personRepository.save(admin);
            email(admin);
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
    public void updatePatron(Patron patron) {
        Person personCheck = personRepository.findById(patron.getUserID()).orElseThrow(
                () -> new IllegalStateException(
                        "Person " +
                                patron.getUserID() +
                                " does not exist."));

        if (patron.getName() != null &&
                patron.getName().length() > 0 &&
                !Objects.equals(personCheck.getName(), patron.getName())) {
            personCheck.setName(patron.getName());
        }

        if (patron.getEmail() != null &&
                patron.getEmail() .length() > 0 &&
                !Objects.equals(personCheck.getEmail(), patron.getEmail() )) {
            personCheck.setEmail(patron.getEmail() );
        }

        if (patron.getPassword() != null &&
                patron.getPassword().length() > 0 &&
                !Objects.equals(personCheck.getPassword(), patron.getPassword())) {
            personCheck.setPassword(patron.getPassword());
        }
        if (patron.getCardNumber() != null &&
                patron.getCardNumber() != 0) {
            Patron p = (Patron) personCheck;
            p.setCardNumber(patron.getCardNumber());
        }
    }

    @Transactional
    public void updateAdmin(Admin admin) {
        Person personCheck = personRepository.findById(admin.getUserID()).orElseThrow(
                () -> new IllegalStateException(
                        "Person " +
                                admin.getUserID() +
                                " does not exist."));

        if (admin.getName() != null &&
                admin.getName().length() > 0 &&
                !Objects.equals(personCheck.getName(), admin.getName())) {
            personCheck.setName(admin.getName());
        }

        if (admin.getEmail() != null &&
                admin.getEmail() .length() > 0 &&
                !Objects.equals(personCheck.getEmail(), admin.getEmail() )) {
            personCheck.setEmail(admin.getEmail() );
        }

        if (admin.getPassword() != null &&
                admin.getPassword().length() > 0 &&
                !Objects.equals(personCheck.getPassword(), admin.getPassword())) {
            personCheck.setPassword(admin.getPassword());
        }
    }

    public Person getPersonByID(Long personID) {
        return personRepository.findById(personID).get();
    }

    public Person login(String email, String password) {
        try {
            Person personTemp = personRepository.findByEmail(email);
            if(personTemp.getPassword().equals(password)){
                return personTemp;
            } else{
                throw new Exception("Incorrect Password");
            }
        } catch(Exception e) {
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

    public List<Admin> getAdmins() {
        return personRepository.findAdmins();
    }

    public List<Patron> getPatrons() {
        return personRepository.findPatrons();
    }
}

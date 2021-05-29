package com.example.C868CapstoneProject.Service;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.Repository.ChargeRepository;
import com.example.C868CapstoneProject.Repository.PersonRepository;
import com.example.C868CapstoneProject.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ChargeRepository chargeRepository;
    private final BookRepository bookRepository;

    @Autowired
    public PersonService(PersonRepository personRepository,
                         ChargeRepository chargeRepository,
                         BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.chargeRepository = chargeRepository;
        this.bookRepository = bookRepository;
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
                Admin a = new Admin(person.getName(), person.getEmail(), person.getPassword());
                personRepository.save(a);
            } else if (type.equals("patron")) {
                Patron b = new Patron(person.getName(), person.getEmail(), person.getPassword(), cardNumber);
                personRepository.save(b);
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
        }
    }

    @Transactional
    public void postAdmin(Admin admin) {
        Optional<Person> patronOptional = personRepository.findById(admin.getUserID());

        if (patronOptional.isPresent()) {
            throw new IllegalStateException("Person is present");
        } else {
            personRepository.save(admin);
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
        personRepository.save(personCheck);
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
                LocalDate dueDate = LocalDate.now().minusDays(14);
                List<Book> lateBooks = bookRepository.getLateBooks(dueDate);
                List<Charge> charges = chargeRepository.findAll();
                boolean exists = false;
                for(int i = 0; i < lateBooks.size(); i++) {
                    Charge c = new Charge(
                            "Overdue Book",
                            0.10,
                            (lateBooks.get(i).getTitle() + " Overdue"),
                            lateBooks.get(i).getPerson());
                    for(int j = 0; j < charges.size(); j++) {
                        if(charges.get(j).getDate().compareTo(c.getDate()) == 0 &&
                            charges.get(j).getDescription().equals(c.getDescription())){
                            exists = true;
                        }
                    }

                    if(!exists) {
                        chargeRepository.save(c);
                    }
                }
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

    public void setPassword(Person person) {
        Person p = getPersonByID(person.getUserID());
        p.setPassword(person.getPassword());
        personRepository.save(p);
    }

    public Long getPersonByCardNumber(Long cardNumber) {
       return personRepository.getPersonByCardNumber(cardNumber);
    }

    public List<Admin> getAdmins() {
        return personRepository.findAdmins();
    }

    public List<Patron> getPatrons() {
        return personRepository.findPatrons();
    }
}

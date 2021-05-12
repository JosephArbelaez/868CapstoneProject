package com.example.C868CapstoneProject.Controller;

import com.example.C868CapstoneProject.Service.PersonService;
import com.example.C868CapstoneProject.model.Patron;
import com.example.C868CapstoneProject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
@CrossOrigin("*")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping(path = "{personID}")
    public Person getPersonByID(@PathVariable("personID") Long personID) {
        return personService.getPersonByID(personID);
    }

    @GetMapping(path = "/cardNumber")
    public List<Long> getCardNumbers() {
        return personService.getCardNumbers();
    }

    @PostMapping(path = "{type}")
    public void postPerson(@PathVariable("type") String type,
                           @RequestParam(required = false) Long cardNumber,
                           @RequestBody Person person) {
        personService.postPerson(person, type, cardNumber);

    }

    @GetMapping(path = "login")
    public Person login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        System.out.println("Controller.login");
        return personService.login(email, password);
    }

    @DeleteMapping(path = "{personID}")
    public void deletePerson(@PathVariable("personID") Long personID) {
        personService.deletePerson(personID);
    }

    @PutMapping(path = "{personID}")
    public void updatePerson(
            @PathVariable("personID") Long personID,
            @RequestParam(required = false) Long cardNumber,
            @RequestBody Person person) {
        personService.updatePerson(personID, person, cardNumber);
    }

    @GetMapping(path = "/confirm/{personID}")
    public RedirectView updatePerson(
            @PathVariable("personID") String personID) {
        personService.registerPerson(Long.parseLong(personID));
        RedirectView rv = new RedirectView();
        rv.setUrl("127.0.0.1");
        return rv;
    }

    @GetMapping(path = "/cardNumber/{cardNumber}")
    public int getPersonByCardNumber(@PathVariable("cardNumber")  Long cardNumber) {
        return personService.getPersonByCardNumber(cardNumber);
    }
}

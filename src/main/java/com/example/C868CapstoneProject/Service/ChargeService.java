package com.example.C868CapstoneProject.Service;


import com.example.C868CapstoneProject.Repository.ChargeRepository;
import com.example.C868CapstoneProject.Repository.PersonRepository;
import com.example.C868CapstoneProject.model.Charge;
import com.example.C868CapstoneProject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ChargeService {

    private final ChargeRepository chargeRepository;
    private final PersonRepository personRepository;

    @Autowired
    public ChargeService(ChargeRepository chargeRepository, PersonRepository personRepository) {
        this.chargeRepository = chargeRepository;
        this.personRepository = personRepository;
    }

    public List<Charge> getCharges() {
        return chargeRepository.findAll();
    }

    public void postCharge(Long id, Charge charge) {
        Optional<Person> personOptional = personRepository.findById(id);
        Optional<Charge> chargeOptional = chargeRepository.findById(charge.getId());

        if(chargeOptional.isPresent()) {
            throw new IllegalStateException("Charge is present");
        } else {

            charge.setPerson(personOptional.get());
            chargeRepository.save(charge);

        }
    }

    public void deleteCharge(Long chargeID) {
        boolean exists = chargeRepository.existsById(chargeID);

        if(!exists) {
            throw new IllegalStateException("Charge " + chargeID + " does not exist.");
        }

        chargeRepository.deleteById(chargeID);
    }

    @Transactional
    public void updateCharge(Charge charge) {
        Charge chargeTemp = chargeRepository.findById(charge.getId()).orElseThrow(
                () -> new IllegalStateException (
                        "Charge with chargeID " +
                                charge.getId() +
                                " does not exist."));

        if (charge.getType() != null &&
                charge.getType().length() > 0 &&
                !Objects.equals(chargeTemp.getType(), charge.getType())) {
            chargeTemp.setType(charge.getType());
        }

        if (charge.getPrice() != 0 &&
                !Objects.equals(chargeTemp.getPrice(), charge.getPrice())) {
            chargeTemp.setPrice(charge.getPrice());
        }

        if (charge.getDescription() != null &&
                charge.getDescription().length() > 0 &&
                !Objects.equals(chargeTemp.getDescription(), charge.getDescription())) {
            chargeTemp.setDescription(charge.getDescription());
        }
        chargeRepository.save(chargeTemp);
    }
}

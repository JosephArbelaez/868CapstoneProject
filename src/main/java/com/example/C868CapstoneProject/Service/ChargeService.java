package com.example.C868CapstoneProject.Service;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.Repository.ChargeRepository;
import com.example.C868CapstoneProject.model.Book;
import com.example.C868CapstoneProject.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ChargeService {

    private final ChargeRepository chargeRepository;

    @Autowired
    public ChargeService(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    public List<Charge> getCharges() {
        return chargeRepository.findAll();
    }

    public void postCharge(Charge charge) {
        Optional<Charge> chargeOptional = chargeRepository.findById(charge.getId());

        if(chargeOptional.isPresent()) {
            throw new IllegalStateException("Charge is present");
        } else {
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
    public void updateCharge(Long chargeID, String type, double price, String description) {
        Charge charge = chargeRepository.findById(chargeID).orElseThrow(
                () -> new IllegalStateException (
                        "Charge with chargeID " +
                                chargeID +
                                " does not exist."));

        if (type != null &&
                type.length() > 0 &&
                !Objects.equals(charge.getType(), type)) {
            charge.setType(type);
        }

        if (price != 0 &&
                !Objects.equals(charge.getPrice(), price)) {
            charge.setPrice(price);
        }

        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(charge.getDescription(), description)) {
            charge.setDescription(description);
        }
    }
}

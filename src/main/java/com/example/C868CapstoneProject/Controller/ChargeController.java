package com.example.C868CapstoneProject.Controller;

import com.example.C868CapstoneProject.Service.BookService;
import com.example.C868CapstoneProject.Service.ChargeService;
import com.example.C868CapstoneProject.model.Book;
import com.example.C868CapstoneProject.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/charge")
public class ChargeController {

    private final ChargeService chargeService;

    @Autowired
    public ChargeController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @GetMapping
    public List<Charge> getCharges() {
        return chargeService.getCharges();
    }

    @PostMapping
    public void postCharge(@RequestBody Charge charge) {
        chargeService.postCharge(charge);
    }

    @DeleteMapping(path = "{chargeID}")
    public void deleteCharge(@PathVariable("chargeID") Long chargeID) {
        chargeService.deleteCharge(chargeID);
    }

    @PutMapping(path = "{chargeID}")
    public void updateCharge(
            @PathVariable("chargeID") Long chargeID,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) String description) {
        chargeService.updateCharge(chargeID, type, price, description);
    }

}

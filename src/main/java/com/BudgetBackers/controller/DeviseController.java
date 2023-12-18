package com.BudgetBackers.controller;
import com.BudgetBackers.model.Devises;
import com.BudgetBackers.services.DeviseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.sql.SQLException;
import java.util.List;

@RestController
public class DeviseController {
    private DeviseService service;

    public DeviseController(DeviseService service) {
        System.out.println("Appel du constructeur de controller");
        this.service = service;
    }

    //Afficher tous les Devises
    @GetMapping("/Devises")
    public List<Devises> getAllDevises() throws SQLException {
        return service.getAllDevises();
    }
    //Inserer un Devise
    @PostMapping("/Devises")
    public void insertDevise(@RequestBody Devises Devise) throws SQLException {
        service.insertDevise(Devise);
    }

    //Mettre à jour un Devise
    @PutMapping("/Devise/update/{id}")
    public void updateDevise(@PathVariable int id, @RequestBody Devises Devise) throws SQLException {
        Devise.setDeviseId(id);
        service.updateDevise(Devise);
    }
}


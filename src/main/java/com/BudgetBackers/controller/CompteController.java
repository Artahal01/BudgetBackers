package com.BudgetBackers.controller;
import com.BudgetBackers.model.Compte;
import com.BudgetBackers.services.CompteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.sql.SQLException;
import java.util.List;

@RestController
public class CompteController {
    private CompteService service;

    public CompteController(CompteService service) {
        System.out.println("Appel du constructeur de controller");
        this.service = service;
    }

    //Afficher tous les Comptes
    @GetMapping("/Comptes")
    public List<Compte> getAllComptes() throws SQLException {
        return service.getAllComptes();
    }
    //Inserer un Compte
    @PostMapping("/Comptes")
    public void insertCompte(@RequestBody Compte Compte) throws SQLException {
        service.insertCompte(Compte);
    }

    //Mettre à jour un Compte
    @PutMapping("/Compte/update/{id}")
    public void updateCompte(@PathVariable int id, @RequestBody Compte Compte) throws SQLException {
        Compte.setCompteId(id);
        service.updateCompte(Compte);
    }
}

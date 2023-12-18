package com.BudgetBackers.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Compte {
    private int compteId;
    private String nom;
    private double solde;
    private String type;
    private Devises devise;
}

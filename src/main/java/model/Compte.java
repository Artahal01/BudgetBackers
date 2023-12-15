package model;

import java.sql.Date;
import java.util.List;

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

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
//    public Compte(int int1, String string, String string2, String string3, Date date, String string4, String string5) {
//    }
    private int compteId;
    private String nom;
    private double solde;
    private Date dateMiseAJour;
    private List<Transactions> transactions;
    private String devise;
    private String type;
}

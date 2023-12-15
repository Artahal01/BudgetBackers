package model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Transactions {
    private int transactionId;
    private String label;
    private Double montant;
    private Timestamp tempsDuTransaction;
    private String typeDeLaTransaction;
    private Compte compte;
}

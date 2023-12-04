package model;

import java.sql.Date;
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
    public Compte(int int1, String string, String string2, String string3, Date date, String string4, String string5) {
    }
    private int compteId;
    private String firstName;
    private String secondName;
    private int age;
    private Date creationDate;
    private String email;
    private String password;
    private int deviseId;
}

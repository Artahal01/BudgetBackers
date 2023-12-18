package com.BudgetBackers.interfaces;

import java.sql.SQLException;
import java.util.List;
import com.BudgetBackers.model.Compte;

public interface CompteDAOInterface {
    void insert(Compte toInsert) throws SQLException;

    List<Compte> getAll() throws SQLException;

    void update(Compte toUpdate) throws SQLException;
}

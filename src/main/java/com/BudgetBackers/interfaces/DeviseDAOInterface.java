package com.BudgetBackers.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.BudgetBackers.model.Devises;

public interface DeviseDAOInterface {
    void insert(Devises toInsert) throws SQLException;

    List<Devises> getAll() throws SQLException;

    void update(Devises toUpdate) throws SQLException;
}

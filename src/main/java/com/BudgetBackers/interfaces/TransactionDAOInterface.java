package com.BudgetBackers.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.BudgetBackers.model.Transactions;

public interface TransactionDAOInterface {
    void insert(Transactions toInsert) throws SQLException;

    List<Transactions> getAll() throws SQLException;

    void update(Transactions toUpdate) throws SQLException;
}

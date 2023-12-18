package com.BudgetBackers.services;
import org.springframework.stereotype.Service;

import com.BudgetBackers.model.Transactions;
import com.BudgetBackers.repository.TransactionsDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class TransactionService {
    private TransactionsDAO dao;
    public TransactionService(TransactionsDAO dao) {
        this.dao = dao;
    }

    public List<Transactions> getAllTransactions() throws SQLException {
        return dao.getAll();
    }

    public void insertTransaction(Transactions Transaction) throws SQLException {
        dao.insert(Transaction);
    }

    public void updateTransaction(Transactions Transaction) throws SQLException {
        dao.update(Transaction);
    }
}

package com.BudgetBackers.repository;

import com.BudgetBackers.model.Compte;
import com.BudgetBackers.model.Devises;
import org.springframework.stereotype.Repository;

import com.BudgetBackers.interfaces.TransactionDAOInterface;
import com.BudgetBackers.model.Transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionsDAO implements TransactionDAOInterface {

    private final Connection connection;

    public TransactionsDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERT INTO TRANSACTIONS
    @Override
    public void insert(Transactions transaction) throws SQLException {
        String sql = "INSERT INTO transactions (transaction_id, label, montant, temps_du_transaction, type_de_la_transaction, compte_id) VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, transaction.getTransactionId());
            preparedStatement.setString(2, transaction.getLabel());
            preparedStatement.setDouble(3, transaction.getMontant());
            preparedStatement.setTimestamp(4, transaction.getTempsDuTransaction());
            preparedStatement.setString(5, transaction.getTypeDeLaTransaction());
            preparedStatement.setInt(6,transaction.getCompte().getCompteId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET ALL TRANSACTIONS
    @Override
    public List<Transactions> getAll() {
        List<Transactions> Transactions = new ArrayList<>();
        String sql = "SELECT t.*, c.*, d.* FROM transaction t JOIN compte c ON t.compte_id = c.compte_id JOIN devises d ON c.devise_id = d.devise_id;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Transactions transaction = new Transactions(
                        result.getInt("transaction_id"),
                        result.getString("label"),
                        result.getDouble("montant"),
                        result.getTimestamp("temps_du_transaction"),
                        result.getString("type_de_la_transaction"),
                        new Compte(
                                result.getInt("compte_id"),
                                result.getString("nom"),
                                result.getDouble("solde"),
                                result.getString("type"),
                                new Devises(
                                        result.getInt("devise_id"),
                                        result.getString("nom_devise"),
                                        result.getString("code_devise")
                                )
                        )
                );
                Transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Transactions;
    }

    // UPDATE TRANSACTIONS
    @Override
    public void update(Transactions transaction) throws SQLException {
        String sql = "UPDATE transactions SET label = ?, montant = ?, temps_du_transaction = ?, type_de_la_transaction = ?, compte_id = ? WHERE transaction_id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(6, transaction.getTransactionId());
            preparedStatement.setString(1, transaction.getLabel());
            preparedStatement.setDouble(2, transaction.getMontant());
            preparedStatement.setTimestamp(3, transaction.getTempsDuTransaction());
            preparedStatement.setString(4, transaction.getTypeDeLaTransaction());
            preparedStatement.setInt(2, transaction.getCompte().getCompteId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



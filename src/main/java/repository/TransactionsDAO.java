package repository;

import org.springframework.stereotype.Repository;

import interfaces.TransactionDAOInterface;
import model.Transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionsDAO implements TransactionDAOInterface {

    private Connection connection;

    public TransactionsDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERT INTO TRANSACTIONS
    @Override
    public void insert(Transactions transaction) throws SQLException {
        String sql = "INSERT INTO transactions (transaction_id, label, compte_id) VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, transaction.getTransactionId());
            preparedStatement.setString(2, transaction.getLabel());
            preparedStatement.setDouble(3, transaction.getMontant());
            preparedStatement.setTimestamp(3, transaction.getTempsDuTransaction());
            preparedStatement.setString(3, transaction.getTypeDeLaTransaction());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET ALL TRANSACTIONS
    @Override
    public List<Transactions> getAll() throws SQLException {
        List<Transactions> allTransactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToTransactionsList(allTransactions, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTransactions;
    }

    // UPDATE TRANSACTIONS
    @Override
    public void update(Transactions transaction) throws SQLException {
        String sql = "UPDATE transactions SET status = ? WHERE transaction_id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, transaction.getStatus());
            preparedStatement.setInt(2, transaction.getTransactionId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert ResultSet to List<Transactions>
    private void convertToTransactionsList(List<Transactions> transactions, ResultSet result) throws SQLException {
        transactions.add(new Transactions(
            result.getInt("transactionId"),
            result.getBoolean("status"),
            result.getInt("compteId")));
}

}



package repository;

import org.springframework.stereotype.Repository;

import interfaces.CompteDAOInterface;
import model.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompteDAO implements CompteDAOInterface {
    private Connection connection;

    public CompteDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERT INTO COMPTES
    @Override
    public void insert(Compte toInsert) throws SQLException{
        String sql = "INSERT INTO comptes (compte_id, first_name, second_name, age, creation_date, email, password ,devise_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getCompteId());
            preparedStatement.setString(2, toInsert.getFirstName());
            preparedStatement.setString(3, toInsert.getSecondName());
            preparedStatement.setInt(4, toInsert.getAge());
            preparedStatement.setDate(5, toInsert.getCreationDate());
            preparedStatement.setString(6, toInsert.getEmail());
            preparedStatement.setString(7, toInsert.getPassword());
            preparedStatement.setInt(8, toInsert.getDeviseId());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET ALL COMPTES
    @Override
    public List<Compte> getAll() throws SQLException {
        List<Compte> allComptes = new ArrayList<>();
        String sql = "SELECT * FROM comptes";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allComptes, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allComptes;
    }

    // UPDATE COMPTES
    @Override
    public void update(Compte toUpdate) throws SQLException {
        String sql = "UPDATE comptes SET first_name = ?, second_name = ?, age = ?, creation_date = ?, email = ?, password = ? WHERE compte_id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getFirstName());
            preparedStatement.setString(2, toUpdate.getSecondName());
            preparedStatement.setInt(3, toUpdate.getAge());
            preparedStatement.setDate(4, toUpdate.getCreationDate());
            preparedStatement.setString(5, toUpdate.getEmail());
            preparedStatement.setString(6, toUpdate.getPassword());
            preparedStatement.setInt(7, toUpdate.getCompteId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void convertToList(List<Compte> Compte, ResultSet result) throws SQLException {
        Compte.add(new Compte(
                result.getInt("compteId"),
                result.getString("firstName"),
                result.getString("secondName"),
                result.getString("age"),
                result.getDate("creationDate"),
                result.getString("email"),
                result.getString("password")));
    }

}

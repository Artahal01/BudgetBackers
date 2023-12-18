package com.BudgetBackers.repository;

import com.BudgetBackers.model.Devises;
import org.springframework.stereotype.Repository;

import com.BudgetBackers.interfaces.CompteDAOInterface;
import com.BudgetBackers.model.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompteDAO implements CompteDAOInterface {
    private final Connection connection;

    public CompteDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERT INTO COMPTES
    @Override
    public void insert(Compte toInsert) throws SQLException{
        String sql = "INSERT INTO comptes (compte_id, nom, solde, type,devise_id) VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getCompteId());
            preparedStatement.setString(2, toInsert.getNom());
            preparedStatement.setDouble(3, toInsert.getSolde());
            preparedStatement.setString(4, toInsert.getType());
            preparedStatement.setInt(5, toInsert.getDevise().getDeviseId());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET ALL COMPTES
    @Override
    public List<Compte> getAll() {
        List<Compte> Comptes = new ArrayList<>();
        String sql = "SELECT * FROM compte c JOIN devises d ON c.devise_id = d.devise_id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Compte compte = new Compte(
                        result.getInt("compte_id"),
                        result.getString("nom"),
                        result.getDouble("solde"),
                        result.getString("type"),
                        new Devises(
                                result.getInt("devise_id"),
                                result.getString("nom_devise"),
                                result.getString("code_devise")
                        )
                );
                Comptes.add(compte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Comptes;
    }

    // UPDATE COMPTES
    @Override
    public void update(Compte toUpdate) throws SQLException {
        String sql = "UPDATE comptes SET nom = ?, solde = ?, type = ?, devise_id = ? WHERE compte_id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(5, toUpdate.getCompteId());
            preparedStatement.setString(1, toUpdate.getNom());
            preparedStatement.setDouble(2, toUpdate.getSolde());
            preparedStatement.setString(3, toUpdate.getType());
            preparedStatement.setInt(4, toUpdate.getDevise().getDeviseId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

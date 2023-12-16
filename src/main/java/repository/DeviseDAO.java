package repository;

import org.springframework.stereotype.Repository;

import interfaces.DeviseDAOInterface;
import model.Devises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeviseDAO implements DeviseDAOInterface {
    private final Connection connection;

    public DeviseDAO(Connection connection) {
        this.connection = connection;
    }
     // INSERT INTO DEVISES
     @Override
     public void insert(Devises devise) throws SQLException {
         String sql = "INSERT INTO devises (devise_id, nom, code) VALUES (?, ?, ?);";
 
         try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(1, devise.getDeviseId());
             preparedStatement.setString(2, devise.getNom());
             preparedStatement.setString(3, devise.getCode());
 
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 
     // GET ALL DEVISES
     @Override
     public List<Devises> getAll() {
         List<Devises> allDevises = new ArrayList<>();
         String sql = "SELECT * FROM devises";
 
         try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             ResultSet result = preparedStatement.executeQuery();
 
             while (result.next()) {
                 convertToDevisesList(allDevises, result);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return allDevises;
     }
 
     // UPDATE DEVISES
     @Override
     public void update(Devises devise) throws SQLException {
         String sql = "UPDATE devises SET name = ?, code = ? WHERE devise_id = ?;";
 
         try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(3, devise.getDeviseId());
             preparedStatement.setString(1, devise.getNom());
             preparedStatement.setString(2, devise.getCode());

 
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     // Helper method to convert ResultSet to List<Devises>
    private void convertToDevisesList(List<Devises> Devises, ResultSet result) throws SQLException {
        Devises.add(new Devises(
            result.getInt("deviseId"),
            result.getString("name"),
            result.getString("code")));
     }
}

package services;
import org.springframework.stereotype.Service;

import model.Devises;
import repository.DeviseDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class DeviseService {
     private DeviseDAO dao;
    public DeviseService(DeviseDAO dao) {
        this.dao = dao;
    }

    public List<Devises> getAllDevises() throws SQLException {
        return dao.getAll();
    }

    public void insertDevise(Devises Devise) throws SQLException {
        dao.insert(Devise);
    }

    public void updateDevise(Devises Devise) throws SQLException {
        dao.update(Devise);
    }
}

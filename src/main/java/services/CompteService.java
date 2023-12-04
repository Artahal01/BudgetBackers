package services;
import org.springframework.stereotype.Service;

import model.Compte;
import repository.CompteDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class CompteService {
    private CompteDAO dao;
    public CompteService(CompteDAO dao) {
        this.dao = dao;
    }

    public List<Compte> getAllComptes() throws SQLException {
        return dao.getAll();
    }

    public void insertCompte(Compte Compte) throws SQLException {
        dao.insert(Compte);
    }

    public void updateCompte(Compte Compte) throws SQLException {
        dao.update(Compte);
    }
}
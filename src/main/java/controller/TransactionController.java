package controller;
import model.Transactions;
import services.TransactionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.sql.SQLException;
import java.util.List;

@RestController
public class TransactionController {
    private TransactionService service;

    public TransactionController(TransactionService service) {
        System.out.println("Appel du constructeur de controller");
        this.service = service;
    }

    //Afficher tous les Transactions
    @GetMapping("/Transactions")
    public List<Transactions> getAllTransactions() throws SQLException {
        return service.getAllTransactions();
    }
    //Inserer un Transaction
    @PostMapping("/Transactions")
    public void insertTransaction(@RequestBody Transactions Transaction) throws SQLException {
        service.insertTransaction(Transaction);
    }

    //Mettre à jour un Transaction
    @PutMapping("/Transaction/update/{id}")
    public void updateTransaction(@PathVariable int id, @RequestBody Transactions Transaction) throws SQLException {
        Transaction.setTransactionId(id);
        service.updateTransaction(Transaction);
    }
}

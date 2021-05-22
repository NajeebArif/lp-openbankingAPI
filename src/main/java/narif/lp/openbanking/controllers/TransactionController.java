package narif.lp.openbanking.controllers;

import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactionsForAccountNumber(@PathVariable  Long accountNumber){
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}

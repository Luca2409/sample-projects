package com.api.testspringboot.Transactions;

import com.plaid.client.model.TransactionsSyncResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // loads all transactions into db
    @GetMapping("/load")
    public TransactionsSyncResponse loadTransactions() throws Exception {

        return transactionService.getTransactions();
    }
}

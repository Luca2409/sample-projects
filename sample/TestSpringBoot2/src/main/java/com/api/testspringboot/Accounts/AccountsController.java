package com.api.testspringboot.Accounts;

import com.plaid.client.model.AccountsGetResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

/*    // loads accounts into db
    @GetMapping
    public AccountsGetResponse loadAccounts() throws IOException {

        return accountsService.retrieveAccounts();
    }*/

    // loads account balances into db
    @GetMapping("/balances")

    public AccountsGetResponse loadAccountsBalance() throws IOException {

        return accountsService.retrieveAccountBalances();
    }

}

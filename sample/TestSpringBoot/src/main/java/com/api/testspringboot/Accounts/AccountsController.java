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

    @GetMapping
    public AccountsGetResponse getAccounts() throws IOException {

        return accountsService.retrieveAccounts();
    }

    @GetMapping("/balances")

    public AccountsGetResponse getAccountsBalance() throws IOException {

        return accountsService.retrieveAccountBalances();
    }

    @GetMapping("/balance")
    public AccountsResponseDto getAccountsBalanceWithQueryParams(@RequestParam Long id) throws IOException {

        return accountsService.retrieveAccountBalance(id);

    }

}

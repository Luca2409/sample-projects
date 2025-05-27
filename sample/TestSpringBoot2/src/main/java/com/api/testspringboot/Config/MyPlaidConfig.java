package com.api.testspringboot.Config;

import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MyPlaidConfig {

    @Value("${plaid.clientId}")
    private String clientId;

    @Value("${plaid.secret}")
    private String secret;

    @Bean
    public ApiClient apiClient() {

        HashMap<String, String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", clientId);
        apiKeys.put("secret", secret);

        return new ApiClient(apiKeys);
    }

    @Bean
    public LinkTokenCreateRequestUser linkTokenCreateRequestUser() {
        return new LinkTokenCreateRequestUser();
    }

    @Bean
    public LinkTokenCreateRequest linkTokenCreateRequest() {
        return new LinkTokenCreateRequest();
    }

    @Bean
    public ItemPublicTokenExchangeRequest itemPublicTokenExchangeRequest() {
        return new ItemPublicTokenExchangeRequest();
    }

    @Bean
    public AccountsGetRequest accountsGetRequest() {
        return new AccountsGetRequest();
    }

    @Bean
    public AccountsBalanceGetRequest accountsBalanceGetRequest() {
        return new AccountsBalanceGetRequest();
    }

    @Bean
    public TransactionsSyncRequest transactionsSyncRequest() {
        return new TransactionsSyncRequest();
    }
}

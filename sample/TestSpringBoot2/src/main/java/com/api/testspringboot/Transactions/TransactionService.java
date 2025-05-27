package com.api.testspringboot.Transactions;

import com.api.testspringboot.Accounts.AccountModel;
import com.api.testspringboot.Accounts.Accounts;
import com.api.testspringboot.Accounts.AccountsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.plaid.client.ApiClient;
import com.plaid.client.model.TransactionsSyncRequest;
import com.plaid.client.model.TransactionsSyncResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TransactionService {

    private final ApiClient apiClient;
    private final TransactionsSyncRequest transactionsSyncRequest;
    private final TransactionsRepository transactionsRepository;
    private final AccountsRepository accountsRepository;

    public TransactionService(ApiClient apiClient, TransactionsSyncRequest transactionsSyncRequest, TransactionsRepository transactionsRepository, AccountsRepository accountsRepository) {
        this.apiClient = apiClient;
        this.transactionsSyncRequest = transactionsSyncRequest;
        this.transactionsRepository = transactionsRepository;
        this.accountsRepository = accountsRepository;
    }

    @Value("${plaid.access.token}")
    private String accessToken;


    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());

    public TransactionsSyncResponse getTransactions() throws Exception {

        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        TransactionsSyncRequest request = transactionsSyncRequest
                .accessToken(accessToken);

        Response<TransactionsSyncResponse> response = plaidClient.transactionsSync(request).execute();

        TransactionsModel transactionsModel = deserializeTransactionsResponse(response);

        List<TransactionsModel.Added> added = transactionsModel.getAdded();

        Accounts account = accountsRepository.getReferenceById(added.getFirst().getAccountId());

        added.forEach(data -> transactionsRepository.save(new Transactions(data, account)));

        return response.body();
    }

    public TransactionsModel deserializeTransactionsResponse(Response response) throws JsonProcessingException {

        String json = mapper.writeValueAsString(response.body());

        return mapper.readValue(json, TransactionsModel.class);
    }
}

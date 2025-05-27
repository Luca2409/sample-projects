package com.api.testspringboot.Transactions;

import com.plaid.client.ApiClient;
import com.plaid.client.model.TransactionsSyncRequest;
import com.plaid.client.model.TransactionsSyncResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@Service
public class TransactionService {

    private final ApiClient apiClient;
    private final TransactionsSyncRequest transactionsSyncRequest;

    public TransactionService(ApiClient apiClient, TransactionsSyncRequest transactionsSyncRequest) {
        this.apiClient = apiClient;
        this.transactionsSyncRequest = transactionsSyncRequest;
    }

    @Value("${plaid.access.token}")
    private String accessToken;

    public TransactionsSyncResponse getTransactions() throws Exception {

        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        TransactionsSyncRequest request = transactionsSyncRequest
                .accessToken(accessToken);

        Response<TransactionsSyncResponse> response = plaidClient.transactionsSync(request).execute();


        return response.body();
    }
}

package com.api.testspringboot.Accounts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plaid.client.ApiClient;
import com.plaid.client.model.AccountsBalanceGetRequest;
import com.plaid.client.model.AccountsGetResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class AccountsService {

    @Value("${plaid.uuid}")
    private String uuid;

    @Value("${plaid.access.token}")
    private String accessToken;

    private final ApiClient apiClient;
    private final AccountsBalanceGetRequest accountsBalanceGetRequest;
    private final AccountsRepository accountsRepository;

    public AccountsService(ApiClient apiClient, AccountsBalanceGetRequest accountsBalanceGetRequest, AccountsRepository accountsRepository) {
        this.apiClient = apiClient;
        this.accountsBalanceGetRequest = accountsBalanceGetRequest;
        this.accountsRepository = accountsRepository;
    }

    private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

    public AccountsGetResponse retrieveAccountBalances() throws IOException {

        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        AccountsBalanceGetRequest request = accountsBalanceGetRequest.accessToken(accessToken);

        Response<AccountsGetResponse> response = plaidClient.accountsBalanceGet(request).execute();

        AccountModel accountModel = deserializeAccountGetResponse(response);

        List<AccountModel.AccountsModel> accountsModel = accountModel.getAccountsModel();

        accountsModel.forEach(data-> accountsRepository.save(new Accounts(data)));

        return response.body();
    }

    public AccountModel deserializeAccountGetResponse(Response response) throws JsonProcessingException {

        String json = mapper.writeValueAsString(response.body());

        return mapper.readValue(json, AccountModel.class);
    }

}

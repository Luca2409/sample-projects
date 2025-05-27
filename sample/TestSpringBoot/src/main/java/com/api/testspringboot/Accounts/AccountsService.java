package com.api.testspringboot.Accounts;

import com.api.testspringboot.Accounts.models.AccountModel;
import com.api.testspringboot.Accounts.models.AccountsModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plaid.client.ApiClient;
import com.plaid.client.model.AccountsBalanceGetRequest;
import com.plaid.client.model.AccountsGetRequest;
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
    private final AccountsGetRequest accountsGetRequest;
    private final AccountsBalanceGetRequest accountsBalanceGetRequest;
    private final AccountsRepository accountsRepository;

    public AccountsService(ApiClient apiClient, AccountsGetRequest accountsGetRequest, AccountsBalanceGetRequest accountsBalanceGetRequest, AccountsRepository accountsRepository) {
        this.apiClient = apiClient;
        this.accountsGetRequest = accountsGetRequest;
        this.accountsBalanceGetRequest = accountsBalanceGetRequest;
        this.accountsRepository = accountsRepository;
    }

    public AccountsGetResponse retrieveAccounts() throws IOException {
        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        AccountsGetRequest request = accountsGetRequest
                .accessToken(accessToken);

        Response<AccountsGetResponse> accountsResponse = plaidClient.accountsGet(request).execute();

        return accountsResponse.body();
    }

    public AccountsGetResponse retrieveAccountBalances() throws IOException {

        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        AccountsBalanceGetRequest request = accountsBalanceGetRequest.accessToken(accessToken);

        Response<AccountsGetResponse> response = plaidClient.accountsBalanceGet(request).execute();

        AccountModel accountModel = deserializeAccountGetResponse(response);

        List<AccountsModel> accountsModel = accountModel.getAccountsModel();

        accountsModel.forEach(data-> accountsRepository.save(new Accounts(data)));

        return response.body();
    }

    public AccountsResponseDto retrieveAccountBalance(Long id) throws IOException {

        Accounts balance = accountsRepository.getReferenceById(id);

        return toAccountsResponseDto(balance);

    }

    public AccountModel deserializeAccountGetResponse(Response response) throws JsonProcessingException {

        // Create Bean
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        String json = mapper.writeValueAsString(response.body());

        return mapper.readValue(json, AccountModel.class);
    }

    public AccountsResponseDto toAccountsResponseDto(Accounts accounts) {

        return new AccountsResponseDto(accounts.getAccountId(), accounts.getBalances(), accounts.getName(), accounts.getOfficialName());

    }
}

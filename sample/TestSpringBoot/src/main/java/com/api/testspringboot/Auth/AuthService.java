package com.api.testspringboot.Auth;

import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class AuthService {

    @Value("${plaid.uuid}")
    private String uuid;

    private final LinkTokenCreateRequest linkTokenCreateRequest;
    private final LinkTokenCreateRequestUser linkTokenCreateRequestUser;
    private final ApiClient apiClient;
    private final ItemPublicTokenExchangeRequest itemPublicTokenExchangeRequest;
    private final AuthRepository authRepository;

    public AuthService(LinkTokenCreateRequest linkTokenCreateRequest, LinkTokenCreateRequestUser linkTokenCreateRequestUser, ApiClient apiClient, ItemPublicTokenExchangeRequest itemPublicTokenExchangeRequest, AuthRepository authRepository) {
        this.linkTokenCreateRequest = linkTokenCreateRequest;
        this.linkTokenCreateRequestUser = linkTokenCreateRequestUser;
        this.apiClient = apiClient;
        this.itemPublicTokenExchangeRequest = itemPublicTokenExchangeRequest;
        this.authRepository = authRepository;
    }

    public LinkTokenCreateResponse retrieveLinkToken(String clientId, String secret) throws IOException {

        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        LinkTokenCreateRequestUser user = linkTokenCreateRequestUser
                .clientUserId(uuid);

        LinkTokenCreateRequest request = linkTokenCreateRequest
                .clientId(clientId)
                .secret(secret)
                .user(user)
                .clientName("Plaid Test App")
                .products(List.of(Products.AUTH))
                .countryCodes(List.of(CountryCode.US))
                .language("en")
                .redirectUri("https://domainname.com/oauth-page.html");

        Response<LinkTokenCreateResponse> response = plaidClient
                .linkTokenCreate(request)
                .execute();

        return response.body();
    }

    public ResponseEntity<String> retrieveAuthToken(String clientId, String secret, String publicToken) throws IOException {

        apiClient.setPlaidAdapter(ApiClient.Sandbox);

        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);

        ItemPublicTokenExchangeRequest request = itemPublicTokenExchangeRequest
                .publicToken(publicToken);

        Response<ItemPublicTokenExchangeResponse> response = plaidClient
                .itemPublicTokenExchange(request)
                .execute();

//        Should be stored persistently in database
        String accessToken = response.body().getAccessToken();
        String itemId = response.body().getItemId();

        String message = "{\"public_token_exchange\": \"complete\"}";

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    public String createInitialUser(User user) {
        authRepository.save(user);
        return "OK";
    }

}

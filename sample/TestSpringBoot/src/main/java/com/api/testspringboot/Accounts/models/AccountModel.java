package com.api.testspringboot.Accounts.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountModel {

    @JsonProperty("accounts")
    private List<AccountsModel> accounts;


    public List<AccountsModel> getAccountsModel() {
        return accounts;
    }

    public void setAccounts(List<AccountsModel> accounts) {
        this.accounts = accounts;
    }

}

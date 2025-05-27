package com.api.testspringboot.Accounts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AccountsModel {

    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("balances")
    private BalancesModel balances;
    @JsonProperty("mask")
    private String mask;
    @JsonProperty("name")
    private String name ;
    @JsonProperty("officialName")
    private String officialName;
    @JsonProperty("type")
    private String type;
    @JsonProperty("subtype")
    private String subtype;
    @JsonProperty("verificationStatus")
    private String verificationStatus;
    @JsonProperty("verificationName")
    private String verificationName;
    @JsonProperty("verificationInsights")
    private String verificationInsights;
    @JsonProperty("persistantAccountId")
    private String persistantAccountId;
    @JsonProperty("holderCategroy")
    private String holderCategroy;

    public String getHolderCategroy() {
        return holderCategroy;
    }

    public void setHolderCategroy(String holderCategroy) {
        this.holderCategroy = holderCategroy;
    }

    public String getPersistantAccountId() {
        return persistantAccountId;
    }

    public void setPersistantAccountId(String persistantAccountId) {
        this.persistantAccountId = persistantAccountId;
    }

    public String getVerificationInsights() {
        return verificationInsights;
    }

    public void setVerificationInsights(String verificationInsights) {
        this.verificationInsights = verificationInsights;
    }

    public String getVerificationName() {
        return verificationName;
    }

    public void setVerificationName(String verificationName) {
        this.verificationName = verificationName;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public BalancesModel getBalances() {
        return balances;
    }

    public void setBalances(BalancesModel balances) {
        this.balances = balances;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

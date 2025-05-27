package com.api.testspringboot.Accounts;

import com.api.testspringboot.Transactions.Transactions;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "Accounts")
public class Accounts {

    @Id
    private String accountId;

    @JdbcTypeCode(SqlTypes.JSON)
    private AccountModel.AccountsModel.BalancesModel balances;

    private String mask;

    private String name ;

    private String officialName;

    private String type;

    private String subtype;

    private String verificationStatus;

    private String verificationName;

    private String verificationInsights;

    private String persistantAccountId;

    private String holderCategroy;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL
    )
    private List<Transactions> transactions;

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public Accounts() {
    }

    public Accounts(AccountModel.AccountsModel accounts) {
        this.accountId = accounts.getAccountId();
        this.balances = accounts.getBalances();
        this.mask = accounts.getMask();
        this.name = accounts.getName();
        this.officialName = accounts.getOfficialName();
        this.type = accounts.getType();
        this.subtype = accounts.getSubtype();
        this.verificationStatus = accounts.getVerificationStatus();
        this.verificationName = accounts.getVerificationName();
        this.verificationInsights = accounts.getVerificationInsights();
        this.persistantAccountId = accounts.getPersistantAccountId();
        this.holderCategroy = accounts.getHolderCategroy();
    }


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

    public AccountModel.AccountsModel.BalancesModel getBalances() {
        return balances;
    }

    public void setBalances(AccountModel.AccountsModel.BalancesModel balances) {
        this.balances = balances;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

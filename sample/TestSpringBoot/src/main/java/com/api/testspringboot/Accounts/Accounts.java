package com.api.testspringboot.Accounts;

import com.api.testspringboot.Accounts.models.AccountsModel;
import com.api.testspringboot.Accounts.models.BalancesModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "Accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;

    @JdbcTypeCode(SqlTypes.JSON)
    private BalancesModel balances;

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

    public Accounts() {
    }

    public Accounts(AccountsModel accounts) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

package com.api.testspringboot.Transactions;


import com.api.testspringboot.Accounts.Accounts;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "accountId",
            referencedColumnName = "accountId",
            nullable = false
    )
    private Accounts account;

    private BigDecimal amount;
    private String isoCurrencyCode;
    private String unofficialCurrencyCode;

    // Json
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> category;

    private String categoryId;
    private String checkNumber;
    private LocalDate date;

    // json
    @JdbcTypeCode(SqlTypes.JSON)
    private TransactionsModel.Added.Location location;

    private String name;
    private String merchantName;
    private String originalDescription;

    // Json
    @JdbcTypeCode(SqlTypes.JSON)
    private TransactionsModel.Added.PaymentMeta paymentMeta;


    private boolean pending;
    private String pendingTransactionId;
    private String accountOwner;
    private String transactionId;
    private String transactionType;
    private String logoUrl;
    private String website;
    private LocalDate authorizedDate;
    private LocalDate authorizedDatetime;
    private LocalDate datetime;
    private String paymentChannel;

    // Json
    @JdbcTypeCode(SqlTypes.JSON)
    private TransactionsModel.Added.PersonalFinanceCategory personalFinanceCategory;
    private String businessFinanceCategory;
    private String transactionCode;
    private String personalFinanceCategoryIconUrl;

    // Json
    @JdbcTypeCode(SqlTypes.JSON)
    private List<TransactionsModel.Added.Counterparty> counterparties;
    private String merchantEntityId;


    public Transactions() {}

    public Transactions(TransactionsModel.Added added, Accounts account) {
        this.account = account;
        this.amount = added.getAmount();
        this.isoCurrencyCode = added.getIsoCurrencyCode();
        this.unofficialCurrencyCode = added.getUnofficialCurrencyCode();
        this.category = added.getCategory();
        this.categoryId = added.getCategoryId();
        this.checkNumber = added.getCheckNumber();
        this.date = added.getDate();
        this.location = added.getLocation();
        this.name = added.getName();
        this.merchantName = added.getMerchantName();
        this.originalDescription = added.getOriginalDescription();
        this.paymentMeta = added.getPaymentMeta();
        this.pending = added.isPending();
        this.pendingTransactionId = added.getPendingTransactionId();
        this.accountOwner = added.getAccountOwner();
        this.transactionId = added.getTransactionId();
        this.transactionType = added.getTransactionType();
        this.logoUrl = added.getLogoUrl();
        this.website = added.getWebsite();
        this.authorizedDate = added.getAuthorizedDate();
        this.authorizedDatetime = added.getAuthorizedDatetime();
        this.datetime = added.getDatetime();
        this.paymentChannel = added.getPaymentChannel();
        this.personalFinanceCategory = added.getPersonalFinanceCategory();
        this.businessFinanceCategory = added.getBusinessFinanceCategory();
        this.transactionCode = added.getTransactionCode();
        this.personalFinanceCategoryIconUrl = added.getPersonalFinanceCategoryIconUrl();
        this.counterparties = added.getCounterparties();
        this.merchantEntityId = added.getMerchantEntityId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public String getUnofficialCurrencyCode() {
        return unofficialCurrencyCode;
    }

    public void setUnofficialCurrencyCode(String unofficialCurrencyCode) {
        this.unofficialCurrencyCode = unofficialCurrencyCode;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getOriginalDescription() {
        return originalDescription;
    }

    public void setOriginalDescription(String originalDescription) {
        this.originalDescription = originalDescription;
    }


    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public String getPendingTransactionId() {
        return pendingTransactionId;
    }

    public void setPendingTransactionId(String pendingTransactionId) {
        this.pendingTransactionId = pendingTransactionId;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocalDate getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(LocalDate authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public LocalDate getAuthorizedDatetime() {
        return authorizedDatetime;
    }

    public void setAuthorizedDatetime(LocalDate authorizedDatetime) {
        this.authorizedDatetime = authorizedDatetime;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getBusinessFinanceCategory() {
        return businessFinanceCategory;
    }

    public void setBusinessFinanceCategory(String businessFinanceCategory) {
        this.businessFinanceCategory = businessFinanceCategory;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public TransactionsModel.Added.Location getLocation() {
        return location;
    }

    public void setLocation(TransactionsModel.Added.Location location) {
        this.location = location;
    }

    public TransactionsModel.Added.PaymentMeta getPaymentMeta() {
        return paymentMeta;
    }

    public void setPaymentMeta(TransactionsModel.Added.PaymentMeta paymentMeta) {
        this.paymentMeta = paymentMeta;
    }

    public TransactionsModel.Added.PersonalFinanceCategory getPersonalFinanceCategory() {
        return personalFinanceCategory;
    }

    public void setPersonalFinanceCategory(TransactionsModel.Added.PersonalFinanceCategory personalFinanceCategory) {
        this.personalFinanceCategory = personalFinanceCategory;
    }

    public String getPersonalFinanceCategoryIconUrl() {
        return personalFinanceCategoryIconUrl;
    }

    public void setPersonalFinanceCategoryIconUrl(String personalFinanceCategoryIconUrl) {
        this.personalFinanceCategoryIconUrl = personalFinanceCategoryIconUrl;
    }

    public List<TransactionsModel.Added.Counterparty> getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(List<TransactionsModel.Added.Counterparty> counterparties) {
        this.counterparties = counterparties;
    }

    public String getMerchantEntityId() {
        return merchantEntityId;
    }

    public void setMerchantEntityId(String merchantEntityId) {
        this.merchantEntityId = merchantEntityId;
    }
}

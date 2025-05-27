package com.api.testspringboot.Transactions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsModel {

    List<Added> added;

    public static class Added {

        private String accountId;
        private BigDecimal amount;
        private String isoCurrencyCode;
        private String unofficialCurrencyCode;
        private List<String> category;
        private String categoryId;
        private String checkNumber;
        @JsonFormat
                (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDate date;
        private Location location;
        private String name;
        private String merchantName;
        private String originalDescription;
        private PaymentMeta paymentMeta;
        private boolean pending;
        private String pendingTransactionId;
        private String accountOwner;
        private String transactionId;
        private String transactionType;
        private String logoUrl;
        private String website;
        @JsonFormat
                (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDate authorizedDate;
        @JsonFormat
                (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDate authorizedDatetime;
        @JsonFormat
                (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDate datetime;
        private String paymentChannel;
        private PersonalFinanceCategory personalFinanceCategory;
        private String businessFinanceCategory;
        private String transactionCode;
        private String personalFinanceCategoryIconUrl;
        private List<Counterparty> counterparties;
        private String merchantEntityId;

        public static class Location {
            private String address;
            private String city;
            private String region;
            private String postalCode;
            private String country;
            private Double lat;
            private Double lon;
            private String storeNumber;

            // Getters and Setters

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getPostalCode() {
                return postalCode;
            }

            public void setPostalCode(String postalCode) {
                this.postalCode = postalCode;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLon() {
                return lon;
            }

            public void setLon(Double lon) {
                this.lon = lon;
            }

            public String getStoreNumber() {
                return storeNumber;
            }

            public void setStoreNumber(String storeNumber) {
                this.storeNumber = storeNumber;
            }
        }

        public static class PaymentMeta {
            private String referenceNumber;
            private String ppdId;
            private String payee;
            private String byOrderOf;
            private String payer;
            private String paymentMethod;
            private String paymentProcessor;
            private String reason;

            // Getters and Setters

            public String getReferenceNumber() {
                return referenceNumber;
            }

            public void setReferenceNumber(String referenceNumber) {
                this.referenceNumber = referenceNumber;
            }

            public String getPpdId() {
                return ppdId;
            }

            public void setPpdId(String ppdId) {
                this.ppdId = ppdId;
            }

            public String getPayee() {
                return payee;
            }

            public void setPayee(String payee) {
                this.payee = payee;
            }

            public String getByOrderOf() {
                return byOrderOf;
            }

            public void setByOrderOf(String byOrderOf) {
                this.byOrderOf = byOrderOf;
            }

            public String getPayer() {
                return payer;
            }

            public void setPayer(String payer) {
                this.payer = payer;
            }

            public String getPaymentMethod() {
                return paymentMethod;
            }

            public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
            }

            public String getPaymentProcessor() {
                return paymentProcessor;
            }

            public void setPaymentProcessor(String paymentProcessor) {
                this.paymentProcessor = paymentProcessor;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }
        }

        public static class PersonalFinanceCategory {
            private String primary;
            private String detailed;
            private String confidenceLevel;

            // Getters and Setters

            public String getPrimary() {
                return primary;
            }

            public void setPrimary(String primary) {
                this.primary = primary;
            }

            public String getDetailed() {
                return detailed;
            }

            public void setDetailed(String detailed) {
                this.detailed = detailed;
            }

            public String getConfidenceLevel() {
                return confidenceLevel;
            }

            public void setConfidenceLevel(String confidenceLevel) {
                this.confidenceLevel = confidenceLevel;
            }
        }

        public static class Counterparty {
            private String name;
            private String entityId;
            private String type;
            private String website;
            private String logoUrl;
            private String confidenceLevel;

            // Getters and Setters

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEntityId() {
                return entityId;
            }

            public void setEntityId(String entityId) {
                this.entityId = entityId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public String getConfidenceLevel() {
                return confidenceLevel;
            }

            public void setConfidenceLevel(String confidenceLevel) {
                this.confidenceLevel = confidenceLevel;
            }
        }


        // Getters and Setters
        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
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

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
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

        public PaymentMeta getPaymentMeta() {
            return paymentMeta;
        }

        public void setPaymentMeta(PaymentMeta paymentMeta) {
            this.paymentMeta = paymentMeta;
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

        public PersonalFinanceCategory getPersonalFinanceCategory() {
            return personalFinanceCategory;
        }

        public void setPersonalFinanceCategory(PersonalFinanceCategory personalFinanceCategory) {
            this.personalFinanceCategory = personalFinanceCategory;
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

        public String getPersonalFinanceCategoryIconUrl() {
            return personalFinanceCategoryIconUrl;
        }

        public void setPersonalFinanceCategoryIconUrl(String personalFinanceCategoryIconUrl) {
            this.personalFinanceCategoryIconUrl = personalFinanceCategoryIconUrl;
        }

        public List<Counterparty> getCounterparties() {
            return counterparties;
        }

        public void setCounterparties(List<Counterparty> counterparties) {
            this.counterparties = counterparties;
        }

        public String getMerchantEntityId() {
            return merchantEntityId;
        }

        public void setMerchantEntityId(String merchantEntityId) {
            this.merchantEntityId = merchantEntityId;
        }

    }

    public List<Added> getAdded() {
        return added;
    }

    public void setAdded(List<Added> added) {
        this.added = added;
    }
}


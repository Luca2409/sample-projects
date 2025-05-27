package com.api.testspringboot.Accounts;



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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AccountsModel {

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

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BalancesModel {

            @JsonProperty("available")
            private long available;
            @JsonProperty("current")
            private long current;
            @JsonProperty("limit")
            private long limit;
            @JsonProperty("isoCurrencyCode")
            private String isoCurrencyCode;
            @JsonProperty("unofficialCurrencyCode")
            private String unofficialCurrencyCode;
            @JsonProperty("lastUpdatedDatetime")
            private String lastUpdatedDatetime;

            public long getCurrent() {
                return current;
            }
            public void setCurrent(long current) {
                this.current = current;
            }

            public long getAvailable() {
                return available;
            }

            public void setAvailable(long available) {
                this.available = available;
            }

            public String getIsoCurrencyCode() {
                return isoCurrencyCode;
            }

            public void setIsoCurrencyCode(String isoCurrencyCode) {
                this.isoCurrencyCode = isoCurrencyCode;
            }

            public long getLimit() {
                return limit;
            }

            public void setLimit(long limit) {
                this.limit = limit;
            }

            public String getUnofficialCurrencyCode() {
                return unofficialCurrencyCode;
            }

            public void setUnofficialCurrencyCode(String unofficialCurrencyCode) {
                this.unofficialCurrencyCode = unofficialCurrencyCode;
            }

            public String getLastUpdatedDatetime() {
                return lastUpdatedDatetime;
            }

            public void setLastUpdatedDatetime(String lastUpdatedDatetime) {
                this.lastUpdatedDatetime = lastUpdatedDatetime;
            }
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



}

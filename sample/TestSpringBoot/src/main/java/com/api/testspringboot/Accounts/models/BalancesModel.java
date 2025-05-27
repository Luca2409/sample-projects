package com.api.testspringboot.Accounts.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalancesModel {
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

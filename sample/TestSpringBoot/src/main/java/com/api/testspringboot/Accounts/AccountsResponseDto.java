package com.api.testspringboot.Accounts;

import com.api.testspringboot.Accounts.models.BalancesModel;

public record AccountsResponseDto(
        String accountId,
        BalancesModel balances,
        String name,
        String officialName) {

}

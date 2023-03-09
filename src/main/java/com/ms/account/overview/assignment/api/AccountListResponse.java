package com.ms.account.overview.assignment.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountListResponse {

    private List<AccountDTO> accounts;
    private int totalNoOfAccounts;
}

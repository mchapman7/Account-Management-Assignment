package com.ms.account.overview.assignment.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountDTO {

    private String id;
    private String number;
    private String name;
    private String type;
    private AccountStatus status;
    private Amount amount;
    private String balanceDate;
}

package com.ms.account.overview.assignment.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionDTO {

    private String id;
    private String description;
    private String number;
    private String currency;
    private String amount;
    private String type;
    private String transactionDate;
}

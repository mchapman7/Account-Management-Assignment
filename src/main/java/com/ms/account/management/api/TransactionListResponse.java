package com.ms.account.management.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionListResponse {
    private List<TransactionDTO> transactions;
    private int totalNoOfTransactions;
}

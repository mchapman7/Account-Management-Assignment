package com.ms.account.overview.assignment.controller;

import com.ms.account.overview.assignment.api.AccountListResponse;
import com.ms.account.overview.assignment.api.TransactionListResponse;
import com.ms.account.overview.assignment.service.AccountOverviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api")
@Validated
public class AccountOverviewController {

    private final AccountOverviewService accountOverviewService;

    @GetMapping(value = "/v1/acctmgmt/user/{userId}/accounts")
    public ResponseEntity<AccountListResponse>  getAccountsByUserId(
            @PathVariable @Valid @Length(min = 4, max = 10) final String userId,
            @RequestHeader final HttpHeaders httpHeaders,
            HttpServletRequest request
            ) {

        AccountListResponse accounts = accountOverviewService.getAccountsByUserId(userId);
        request.setAttribute("apiStatus", HttpStatus.OK);

        return ResponseEntity.ok(accounts);

    }

    @GetMapping(value = "/v1/acctmgmt/user/{userId}/account/{accountId}/transactions")
    public ResponseEntity<TransactionListResponse>  getTransactionsByUserIdAndAccountId(
            @PathVariable @Valid @Length(min = 4, max = 10) final String userId,
            @PathVariable @Valid @Length(min = 4, max = 10) final String accountId,
            @RequestHeader final HttpHeaders httpHeaders,
            HttpServletRequest request
    ) {

        TransactionListResponse transactions = accountOverviewService.getTransactionsByUserIdAndAccountId(userId,accountId);
        request.setAttribute("apiStatus", HttpStatus.OK);

        return ResponseEntity.ok(transactions);

    }
}

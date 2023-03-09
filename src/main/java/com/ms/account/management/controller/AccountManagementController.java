package com.ms.account.management.controller;

import com.ms.account.management.api.AccountListResponse;
import com.ms.account.management.api.TransactionListResponse;
import com.ms.account.management.common.RegexConstants;
import com.ms.account.management.service.AccountManagementService;
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
import javax.validation.constraints.Pattern;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api")
@Validated
public class AccountManagementController {

    public static final String API_STATUS_KEY = "apiStatus";
    private final AccountManagementService accountManagementService;

    /**
     * Get request mapping to retrieve list of accounts for the user
     *
     * @param userId
     * @param request
     * @return
     */
    @GetMapping(value = "/v1/acctmgmt/users/{userId}/accounts")
    public ResponseEntity<AccountListResponse>  getAccountsByUserId(
            @PathVariable @Valid @Pattern(regexp = RegexConstants.USER_ID_VALIDATION) final String userId,
            HttpServletRequest request
            ) {

        AccountListResponse accounts = accountManagementService.getAccountsByUserId(userId);
        request.setAttribute(API_STATUS_KEY, HttpStatus.OK);

        return ResponseEntity.ok(accounts);

    }

    /**
     * Get request mapping to retrieve transactions for the user and account
     *
     * @param userId
     * @param accountId
     * @param request
     * @return
     */
    @GetMapping(value = "/v1/acctmgmt/users/{userId}/accounts/{accountId}/transactions")
    public ResponseEntity<TransactionListResponse>  getTransactionsByUserIdAndAccountId(
            @PathVariable @Valid @Pattern(regexp = RegexConstants.USER_ID_VALIDATION) final String userId,
            @PathVariable @Valid @Pattern(regexp = RegexConstants.ACCOUNT_ID_VALIDATION) final String accountId,
            HttpServletRequest request
    ) {

        TransactionListResponse transactions = accountManagementService.getTransactionsByUserIdAndAccountId(userId,accountId);
        request.setAttribute("apiStatus", HttpStatus.OK);

        return ResponseEntity.ok(transactions);

    }
}

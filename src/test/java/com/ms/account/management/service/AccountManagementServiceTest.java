package com.ms.account.management.service;

import com.ms.account.management.api.TransactionListResponse;
import com.ms.account.management.exception.DataNotFoundException;
import com.ms.account.management.repository.AccountRepository;
import com.ms.account.management.repository.TransactionRepository;
import com.ms.account.management.repository.entity.Account;
import com.ms.account.management.repository.entity.Transaction;
import com.ms.account.management.api.AccountListResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountManagementServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountManagementService accountManagementService;

    private Account account;
    private Transaction transaction;

    @BeforeEach
    public void setUp(){

        account = Account.builder()
                .accountId(1l)
                .number(123456)
                .name("Test Account")
                .type("Savings")
                .balanceDate(new Date())
                .balance(1234.45)
                .status("OPENED")
                .currency("AUD")
                .build();

        transaction = Transaction.builder()
                .transactionId(2l)
                .description("Testing description")
                .transactionDate(new Date())
                .currency("AUD")
                .amount(1234.45)
                .type("Credit")
                .account(account)
                .build();

    }

    @Test
    void givenUserId_whenGetAccountsByUserId_thenReturnAccountList() {

        given(accountRepository.findByUserUserId(1l)).willReturn(List.of(account));

        AccountListResponse accountList = accountManagementService.getAccountsByUserId("1");

        assertNotNull(accountList);
        assertEquals(1, accountList.getTotalNoOfAccounts());
    }

    @Test
    void getAccountsByUserIdNotExist_shouldThrowException() {

        given(accountRepository.findByUserUserId(2L)).willReturn(new ArrayList<>());
        Assertions.assertThatThrownBy(() -> accountManagementService.getAccountsByUserId("2"))
                .isInstanceOf(DataNotFoundException.class)
                .hasMessage("No accounts for the user id - 2");
    }

    @Test
    void getTransactionsByUserIdAndAccountId() {
        given(transactionRepository.findByAccountUserUserIdAndAccountAccountId(1L, 2L))
                .willReturn(List.of(transaction));

        TransactionListResponse transactions = accountManagementService.getTransactionsByUserIdAndAccountId("1", "2");

        assertNotNull(transactions);
        assertEquals(1, transactions.getTotalNoOfTransactions());
    }

    @Test
    void getTransactionsByUserIdAndAccountIdNotExist_shouldThrowException() {

        given(transactionRepository.findByAccountUserUserIdAndAccountAccountId(1L, 2L))
                .willReturn(new ArrayList<>());
        Assertions.assertThatThrownBy(() -> accountManagementService.getTransactionsByUserIdAndAccountId("1", "2"))
                .isInstanceOf(DataNotFoundException.class)
                .hasMessage("No transactions for the user id - 1 and account id - 2");
    }
}
package com.ms.account.overview.assignment.service;

import com.ms.account.overview.assignment.api.AccountListResponse;
import com.ms.account.overview.assignment.api.TransactionListResponse;
import com.ms.account.overview.assignment.exception.AccountsNotFoundException;
import com.ms.account.overview.assignment.exception.TransactionsNotFoundException;
import com.ms.account.overview.assignment.repository.AccountRepository;
import com.ms.account.overview.assignment.repository.TransactionRepository;
import com.ms.account.overview.assignment.repository.entity.Account;
import com.ms.account.overview.assignment.repository.entity.Transaction;
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
class AccountOverviewServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountOverviewService accountOverviewService;

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

        AccountListResponse accountList = accountOverviewService.getAccountsByUserId("1");

        assertNotNull(accountList);
        assertEquals(1, accountList.getTotalNoOfAccounts());
    }

    @Test
    void getAccountsByUserIdNotExist_shouldThrowException() {

        given(accountRepository.findByUserUserId(2L)).willReturn(new ArrayList<>());
        Assertions.assertThatThrownBy(() -> accountOverviewService.getAccountsByUserId("2"))
                .isInstanceOf(AccountsNotFoundException.class)
                .hasMessage("No accounts for the user 2 ");
    }

    @Test
    void getTransactionsByUserIdAndAccountId() {
        given(transactionRepository.findByAccountUserUserIdAndAccountAccountId(1L, 2L))
                .willReturn(List.of(transaction));

        TransactionListResponse transactions = accountOverviewService.getTransactionsByUserIdAndAccountId("1", "2");

        assertNotNull(transactions);
        assertEquals(1, transactions.getTotalNoOfTransactions());
    }

    @Test
    void getTransactionsByUserIdAndAccountIdNotExist_shouldThrowException() {

        given(transactionRepository.findByAccountUserUserIdAndAccountAccountId(1L, 2L))
                .willReturn(new ArrayList<>());
        Assertions.assertThatThrownBy(() -> accountOverviewService.getTransactionsByUserIdAndAccountId("1", "2"))
                .isInstanceOf(TransactionsNotFoundException.class)
                .hasMessage("No Transactions for the user id 1 and account id 2");
    }
}
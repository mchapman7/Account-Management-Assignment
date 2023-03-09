package com.ms.account.overview.assignment.controller;

import com.ms.account.overview.assignment.api.AccountDTO;
import com.ms.account.overview.assignment.api.AccountListResponse;
import com.ms.account.overview.assignment.api.TransactionDTO;
import com.ms.account.overview.assignment.api.TransactionListResponse;
import com.ms.account.overview.assignment.service.AccountOverviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountOverviewController.class)
public class AccountOverviewIntegrationTests {

    @MockBean
    private AccountOverviewService service;
    @Autowired
    private MockMvc mockMvc;
    private AccountListResponse accountListResponse;
    private TransactionListResponse transactionListResponse;

    @BeforeEach
    public void setUp() {

        AccountDTO accountDTO = AccountDTO.builder()
                .id("123456")
                .name("Test Name")
                .build();
        accountListResponse = AccountListResponse.builder()
                .accounts(List.of(accountDTO))
                .totalNoOfAccounts(List.of(accountDTO).size())
                .build();

        TransactionDTO transactionDTO = TransactionDTO.builder()
                .id("2222")
                .description("test description")
                .build();
        transactionListResponse = TransactionListResponse.builder()
                .transactions(List.of(transactionDTO))
                .totalNoOfTransactions(List.of(transactionDTO).size())
                .build();

    }
    @Test
    public void shouldReturnAccountsForGivenUserId() throws Exception {

        Mockito.when(service.getAccountsByUserId("1111")).thenReturn(accountListResponse);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/acctmgmt/user/1111/accounts")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[*].id").isNotEmpty());
    }

    @Test
    public void shouldReturnInternalServerExceptionForInvalidUserId() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/acctmgmt/user/111/accounts")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void shouldReturnTransactionsForGivenUserIdAndAccountId() throws Exception {

        Mockito.when(service.getTransactionsByUserIdAndAccountId("1111", "2222"))
                .thenReturn(transactionListResponse);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/acctmgmt/user/1111/account/2222/transactions")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactions").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactions[*].id").isNotEmpty());
    }
}

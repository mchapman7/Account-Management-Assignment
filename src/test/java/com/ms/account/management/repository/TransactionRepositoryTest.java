package com.ms.account.management.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void findTransactionsByValidUserIdAndValidAccountId() {
        assertEquals(3,
                transactionRepository.findByAccountUserUserIdAndAccountAccountId(1111L, 123456L).size());
    }

    @Test
    void findTransactionsByValidUserIdAndInvalidAccountId() {
        assertEquals(0,
                transactionRepository.findByAccountUserUserIdAndAccountAccountId(2L, 000L).size());
    }

    @Test
    void findTransactionsByInvalidUserIdAndValidAccountId() {
        assertEquals(0,
                transactionRepository.findByAccountUserUserIdAndAccountAccountId(555L, 123456L).size());
    }

    @Test
    void findTransactionsByInvalidUserIdAndInvalidAccountId() {
        assertEquals(0,
                transactionRepository.findByAccountUserUserIdAndAccountAccountId(555L, 5555L).size());
    }
}
package com.ms.account.overview.assignment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findAccountsByExistUserIdShouldReturnListWithValues() {
        assertEquals(3, accountRepository.findByUserUserId(1111l).size());
    }

    @Test
    public void findAccountsByNonExistUserIdShouldReturnListWithEmptyValues() {
        assertEquals(0, accountRepository.findByUserUserId(006l).size());
    }
}
package com.ms.account.overview.assignment;

import com.ms.account.overview.assignment.repository.AccountRepository;
import com.ms.account.overview.assignment.repository.TransactionRepository;
import com.ms.account.overview.assignment.repository.entity.Account;
import com.ms.account.overview.assignment.repository.entity.Transaction;
import com.ms.account.overview.assignment.service.AccountOverviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}

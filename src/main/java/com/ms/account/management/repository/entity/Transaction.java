package com.ms.account.management.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaction {
    @Id
    private Long transactionId;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    private String currency;
    private Double amount;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"
    )
    private Account account;
}

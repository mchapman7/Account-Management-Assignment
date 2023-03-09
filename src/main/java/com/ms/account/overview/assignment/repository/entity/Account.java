package com.ms.account.overview.assignment.repository.entity;

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
public class Account {
    @Id
    private Long accountId;
    private Integer number;
    private String name;
    private String type;
    private String status;
    private String currency;
    private Double balance;
    @Temporal(TemporalType.DATE)
    private Date balanceDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;

}

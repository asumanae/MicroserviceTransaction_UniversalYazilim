package com.universal_yazilim.bid.ysm.transaction_app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "TRANSACTIONS_SEQUENCE", sequenceName = "TRANSACTIONS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "TRANSACTIONS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_SEQUENCE")
    @Column(nullable = false)
    private Integer transactionID;
    @Column(nullable = false, name = "USER_ID")
    private String userID;
    @Column(nullable = false, name = "PRODUCT_ID")
    private Integer productID;
    @Column(nullable = false, name = "TRANSACTION_TIME")
    private Date transactionTime;
}

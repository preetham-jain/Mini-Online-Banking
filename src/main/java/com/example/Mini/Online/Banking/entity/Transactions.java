package com.example.Mini.Online.Banking.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Transactions {
    @Id
    @GenericGenerator(name = "transaction_id_seq", strategy = "increment")
    @GeneratedValue(generator = "transactions_id_seq", strategy = GenerationType.AUTO)
    private int id;

    private String type;
    private String status;
    private double amount;
    private double availableBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}

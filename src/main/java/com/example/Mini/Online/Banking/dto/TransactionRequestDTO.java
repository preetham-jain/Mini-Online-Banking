package com.example.Mini.Online.Banking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {
    private String senderAccount;
    private String recipientAccount;
    private String pin;
    private double amount;
}

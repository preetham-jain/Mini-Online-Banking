package com.example.Mini.Online.Banking.controller;

import com.example.Mini.Online.Banking.dto.AccountResponseDTO;
import com.example.Mini.Online.Banking.dto.TransactionResponseDTO;
import com.example.Mini.Online.Banking.dto.WithdrawRequestDTO;
import com.example.Mini.Online.Banking.dto.WithdrawResponseDTO;
import com.example.Mini.Online.Banking.services.AccountService;
import com.example.Mini.Online.Banking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    public List<AccountResponseDTO> getAccountsById(@PathVariable("id") Long id) {
        return accountService.getAccountsById(id);
    }

    @PutMapping("/withdraw/{id}")
    public WithdrawResponseDTO withdrawFromAccount(@RequestBody WithdrawRequestDTO withdrawRequestDTO, @PathVariable Long id) {
        return accountService.withdrawFromAccountById(withdrawRequestDTO, id);
    }


 }

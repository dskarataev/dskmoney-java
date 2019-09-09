package com.dskarataev.dskmoney.account.service;

import com.dskarataev.dskmoney.account.entity.Account;
import com.dskarataev.dskmoney.account.entity.AccountPlan;
import com.dskarataev.dskmoney.account.repository.AccountEventRepository;
import com.dskarataev.dskmoney.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountEventRepository accountEventRepository;

}

package com.dskarataev.dskmoney.account.entity;

import com.dskarataev.dskmoney.account.exception.InvalidCurrencyException;
import lombok.Data;

import java.util.Currency;

@Data
public class Account {
    private final String title;
    private final String currencyCode;
    private final IncreasedBy increasedBy;

    public Account(String title, IncreasedBy increasedBy) {
        this.title = title;
        this.currencyCode = "USD";
        this.increasedBy = increasedBy;
    }

    public Account(String title, String currencyCode, IncreasedBy increasedBy) throws InvalidCurrencyException {

        try {
            Currency.getInstance(currencyCode);
        } catch (Exception e) {
            throw new InvalidCurrencyException("", e);
        }

        this.title = title;
        this.currencyCode = currencyCode;
        this.increasedBy = increasedBy;
    }

    public enum IncreasedBy {
        DEBIT, CREDIT;
    }
}


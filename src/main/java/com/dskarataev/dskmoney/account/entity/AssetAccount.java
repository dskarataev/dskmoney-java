package com.dskarataev.dskmoney.account.entity;

import com.dskarataev.dskmoney.account.exception.InvalidClosedAtException;
import com.dskarataev.dskmoney.account.exception.InvalidCurrencyException;
import com.dskarataev.dskmoney.account.exception.InvalidCreatedAtException;

import java.time.ZonedDateTime;

public class AssetAccount extends UserAccount {

    public AssetAccount(String title, String currencyCode) throws InvalidCurrencyException {
        super(title, currencyCode, IncreasedBy.DEBIT);
    }

    public AssetAccount(String title, String currencyCode, ZonedDateTime createdAt) throws InvalidCurrencyException, InvalidCreatedAtException {
        super(title, currencyCode, IncreasedBy.DEBIT, createdAt);
    }

    public AssetAccount(String title, String currencyCode, ZonedDateTime createdAt, ZonedDateTime closedAt) throws InvalidCurrencyException, InvalidCreatedAtException, InvalidClosedAtException {
        super(title, currencyCode, IncreasedBy.DEBIT, createdAt, closedAt);
    }
}

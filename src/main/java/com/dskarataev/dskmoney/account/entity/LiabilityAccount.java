package com.dskarataev.dskmoney.account.entity;

import com.dskarataev.dskmoney.account.exception.InvalidClosedAtException;
import com.dskarataev.dskmoney.account.exception.InvalidCurrencyException;
import com.dskarataev.dskmoney.account.exception.InvalidCreatedAtException;

import java.time.ZonedDateTime;

public class LiabilityAccount extends UserAccount {

    public LiabilityAccount(String title, String currencyCode) throws InvalidCurrencyException {
        super(title, currencyCode, IncreasedBy.CREDIT);
    }

    public LiabilityAccount(String title, String currencyCode, ZonedDateTime createdAt) throws InvalidCurrencyException, InvalidCreatedAtException {
        super(title, currencyCode, IncreasedBy.CREDIT, createdAt);
    }

    public LiabilityAccount(String title, String currencyCode, ZonedDateTime createdAt, ZonedDateTime closedAt) throws InvalidCurrencyException, InvalidCreatedAtException, InvalidClosedAtException {
        super(title, currencyCode, IncreasedBy.CREDIT, createdAt, closedAt);
    }
}

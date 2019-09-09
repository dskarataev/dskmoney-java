package com.dskarataev.dskmoney.account.event;

import lombok.Value;

import javax.money.MonetaryAmount;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Value
public class AccountCreated implements AccountEvent, Serializable {
    MonetaryAmount balance;
    ZonedDateTime createdAt;
}

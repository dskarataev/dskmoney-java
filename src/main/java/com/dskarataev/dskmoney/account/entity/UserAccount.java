package com.dskarataev.dskmoney.account.entity;

import com.dskarataev.dskmoney.account.exception.InvalidClosedAtException;
import com.dskarataev.dskmoney.account.exception.InvalidCurrencyException;
import com.dskarataev.dskmoney.account.exception.InvalidCreatedAtException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
abstract class UserAccount extends Account {
    private final ZonedDateTime createdAt;
    @Setter(AccessLevel.NONE)
    private ZonedDateTime closedAt;

    UserAccount(String title, String currencyCode, IncreasedBy increasedBy) throws InvalidCurrencyException {
        super(title, currencyCode, increasedBy);

        createdAt = ZonedDateTime.now();
    }

    UserAccount(String title, String currencyCode, IncreasedBy increasedBy, ZonedDateTime createdAt) throws InvalidCurrencyException, InvalidCreatedAtException {
        super(title, currencyCode, increasedBy);

        validateCustomCreatedAt(createdAt);

        this.createdAt = createdAt;
    }

    UserAccount(String title, String currencyCode, IncreasedBy increasedBy, ZonedDateTime createdAt, ZonedDateTime closedAt) throws InvalidCurrencyException, InvalidCreatedAtException, InvalidClosedAtException {
        super(title, currencyCode, increasedBy);

        validateCustomCreatedAt(createdAt);

        this.createdAt = createdAt;

        close(closedAt);
    }

    private void validateCustomCreatedAt(ZonedDateTime createdAt) throws InvalidCreatedAtException {

        if (createdAt.isAfter(ZonedDateTime.now())) {
            throw new InvalidCreatedAtException("Account open time cannot be in the future");
        }
    }

    public void close() {

        closedAt = ZonedDateTime.now();
    }

    public void close(ZonedDateTime closedAt) throws InvalidClosedAtException {

        if (closedAt.isAfter(ZonedDateTime.now())) {
            throw new InvalidClosedAtException("Account close time cannot be in the future");
        }

        if (closedAt.isBefore(createdAt)) {
            throw new InvalidClosedAtException("Account close time cannot be before open time");
        }

        this.closedAt = closedAt;
    }
}

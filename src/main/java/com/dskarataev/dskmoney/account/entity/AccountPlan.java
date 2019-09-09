package com.dskarataev.dskmoney.account.entity;

import com.dskarataev.dskmoney.account.exception.InvalidAccountType;
import lombok.Data;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@Data
public class AccountPlan {
    private final Map<SystemAccount, AccountPlanNode> accounts;

    public AccountPlan() {
        accounts = new EnumMap<>(SystemAccount.class);

        Account equity = new Account(SystemAccount.EQUITY.toString(), Account.IncreasedBy.CREDIT);
        AccountPlanNode equityNode = new AccountPlanNode(equity);
        accounts.put(SystemAccount.EQUITY, equityNode);

        Account assets = new Account(SystemAccount.ASSETS.toString(), Account.IncreasedBy.DEBIT);
        AccountPlanNode assetsNode = new AccountPlanNode(assets);
        accounts.put(SystemAccount.ASSETS, assetsNode);

        Account liabilities = new Account(SystemAccount.LIABILITIES.toString(), Account.IncreasedBy.CREDIT);
        AccountPlanNode liabilitiesNode = new AccountPlanNode(liabilities);
        accounts.put(SystemAccount.LIABILITIES, liabilitiesNode);

        Account income = new Account(SystemAccount.INCOME.toString(), Account.IncreasedBy.CREDIT);
        AccountPlanNode incomeNode = new AccountPlanNode(income);
        accounts.put(SystemAccount.INCOME, incomeNode);

        Account expenses = new Account(SystemAccount.EXPENSES.toString(), Account.IncreasedBy.DEBIT);
        AccountPlanNode expensesNode = new AccountPlanNode(expenses);
        accounts.put(SystemAccount.EXPENSES, expensesNode);

        System.out.println(toString());
    }

    public AccountPlanNode addAccount(UserAccount account, SystemAccount type) throws InvalidAccountType {

        if (SystemAccount.EQUITY.equals(type)) {
            throw new InvalidAccountType("Equity account can be just one in the system");
        }

        AccountPlanNode parentNode = accounts.get(type);

        return addAccount(account, parentNode);
    }

    public AccountPlanNode addAccount(UserAccount account, AccountPlanNode parentNode) {

        AccountPlanNode currentNode = new AccountPlanNode(account);
        parentNode.children.add(currentNode);

        return currentNode;
    }

    @Value
    public class AccountPlanNode {
        Account account;
        List<AccountPlanNode> children = new ArrayList<>();
    }

    public enum SystemAccount {
        ASSETS, LIABILITIES, INCOME, EXPENSES, EQUITY;
    }
}


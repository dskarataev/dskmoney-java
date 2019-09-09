package com.dskarataev.dskmoney;

import com.dskarataev.dskmoney.account.entity.Account;
import com.dskarataev.dskmoney.account.entity.AccountPlan;
import com.dskarataev.dskmoney.account.entity.AssetAccount;
import com.dskarataev.dskmoney.account.exception.InvalidAccountType;
import com.dskarataev.dskmoney.account.exception.InvalidCurrencyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DskmoneyApplication {

	public static void main(String[] args) {
		AccountPlan accountPlan = new AccountPlan();

		try {
			AssetAccount testAccount = new AssetAccount("Test", "USD");
			accountPlan.addAccount(testAccount, AccountPlan.SystemAccount.ASSETS);
			System.out.println(accountPlan);
		} catch (InvalidCurrencyException | InvalidAccountType e) {
			System.out.println(e);
		}


//		SpringApplication.run(DskmoneyApplication.class, args);
	}

}

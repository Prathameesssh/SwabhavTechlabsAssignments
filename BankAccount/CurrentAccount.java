package com.aurionpro.BankAccount;

import com.aurionpro.model.AccountType;

public class CurrentAccount extends Account implements Comparable<Account> {

	private double overDraftLimit = 50000;
	private AccountType accountType;

	public CurrentAccount(double balance, String name) {
		super(balance, name);
		this.accountType = AccountType.Current;
	}

	@Override
	public void depositAmount(double amount) {
		double balance = getBalance();
		if (overDraftLimit < 50000) {
			double remainingSum = 50000 - overDraftLimit;

			if (remainingSum >= amount) {
				overDraftLimit += amount;
				System.out.println("All the amount has been transferred to the overDraft Limit");
				System.out.println("Still " + (50000 - overDraftLimit) + " is remaining");
			} else {
				setBalance(amount + balance - remainingSum);
				overDraftLimit = 50000;
				System.out.println(remainingSum + " has been transferred to overdraft");
			}
		} else {
			setBalance(amount + balance);
		}

		System.out.println("Amount has been Deposited");
		balance = getBalance();
		System.out.println("Balance is " + balance);
	}

	@Override
	public void withdrawAmount(double amount) {
		double totalAmount = overDraftLimit + getBalance();
		if (amount < totalAmount) {
			totalAmount -= amount;
			if (totalAmount <= 50000) {
				setBalance(0);
				overDraftLimit = totalAmount;
				System.out.println("Overdraft being used");
				System.out.println("remaining overdraft: " + totalAmount);
			} else {
				setBalance(totalAmount - 50000);
			}
		} else {
			throw new CustomException("You only have 50000 overdraft limit");
		}

	}

	public AccountType getAccountType() {
		return accountType;
	}

	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		double diff = this.getBalance() - o.getBalance();

		if (diff > 0)
			return 1;
		if (diff < 0)
			return -1;
		return 0;
	}
}

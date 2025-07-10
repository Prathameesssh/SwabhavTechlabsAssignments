package com.aurionpro.BankAccount;

import com.aurionpro.model.AccountType;

public class SavingsAccount extends Account implements Comparable<Account> {
	
	private AccountType accountType;
	
	public SavingsAccount(double balance, String name) {
		super(balance,name);
		this.accountType = AccountType.Savings;
	}
	
	@Override
	public void depositAmount(double amount) {
		double balance=getBalance();
		setBalance(amount+balance);
		System.out.println("Amount has been Deposited");
		balance=getBalance();
		System.out.println("Balance is "+balance);
	}
	
	@Override
	public void withdrawAmount(double amount) {
		double balance = getBalance();
		if((balance-amount)>500) {
		balance-=amount;
		balance = getBalance();
		System.out.println("Amount has been Withdrawn");
		System.out.println("Balance is "+balance);
		} else {
			throw new CustomException("You have to maintain the minimum balance of 500");
		}
	}

	public AccountType getAccountType() {
		return accountType;
	}

	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		double diff = this.getBalance()-o.getBalance();
		
		if(diff>0)
			return 1;
		if(diff<0)
			return -1;
		return 0;
	}
}

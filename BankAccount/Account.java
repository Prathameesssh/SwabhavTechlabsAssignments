package com.aurionpro.BankAccount;

import java.util.Random;

abstract public class Account {

	private String accountNumber;
	private double balance;
	private String name;
	
	public Account(double balance, String name) {
		String accountNumber = "IDBI";
		Random r = new Random();
		accountNumber  = accountNumber+ r.nextLong(100000000, 999999999);
		this.accountNumber = accountNumber; 
		this.balance = balance;
		this.name = name;
	}
	
	public Account() {
		System.out.println("");
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void depositAmount(double amount);
	
	public abstract void withdrawAmount(double amount);
}

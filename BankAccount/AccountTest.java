package com.aurionpro.BankAccount;

import java.util.*;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Account> currentAccounts = new ArrayList<>();
		List<Account> savingsAccounts = new ArrayList<>();
		System.out.println("Hello and Welcome to IDBI Bank");

		createAcc(scanner, savingsAccounts, currentAccounts);
		
		

	}

	private static void createSavingsAccount(Scanner scanner, double money, String name, List<Account> savingsAccounts,
			List<Account> currentAccounts) {
		SavingsAccount savingsAccount = new SavingsAccount(money, name);
		savingsAccounts.add(savingsAccount);

		boolean isExit = false;
		while (!isExit) {
			System.out.println(
					"Please select the number: \n1.View Balance \n2.Deposit amount \n3.Withdraw \n4.Exit \5.Create account");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				double balance = savingsAccount.getBalance();
				System.out.println("Balance is " + balance);
				break;
			case 2: {
				System.out.println("Enter the money to be deposited");
				try {
					double money1 = scanner.nextDouble();
					if (money1 < 500)
						throw new CustomException("The deposit amount should be greater than 500");
					savingsAccount.depositAmount(money1);
				} catch (CustomException exception) {
					System.out.println(exception.getMessage());
				}
				break;

			}
			case 3: {
				System.out.println("Enter the money to be withdrawn");
				try {
					double money1 = scanner.nextDouble();
					savingsAccount.withdrawAmount(money1);
					break;
				} catch (CustomException exception) {
					System.out.println(exception.getMessage());
				}
			}
			case 4: {
				System.out.println("Thank you for working with us");
				System.exit(0);
			}
			case 5: {
				createAcc(scanner, savingsAccounts, currentAccounts);

			}
			default:
				System.out.println("Choose one of the given option");
			}
		}

	}

	private static void createAcc(Scanner scanner, List<Account> savingsAccounts, List<Account> currentAccounts) {
		// TODO Auto-generated method stub
		boolean isExit = false;

		System.out.println("Enter your name:");
		String name = scanner.next();
		while (true) {
			System.out.println("Enter the initial balance to be deposited: ");
			try {
				double money = scanner.nextDouble();
				if (money < 500) {
					throw new CustomException("The amount cannot be negative");
				}

				System.out.println("Enter the account Type: (1. Savings, 2.Current)");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					createSavingsAccount(scanner, money, name, savingsAccounts, currentAccounts);
					break;
				}

				case 2: {
					createCurrentAccount(scanner, money, name, savingsAccounts, currentAccounts);
					break;
				}
				default:
					System.out.println("Choose correct option");
				}
			} catch (CustomException exception) {
				System.out.println(exception.getMessage());
			}
		}

	}

	public static void createCurrentAccount(Scanner scanner, double money, String name, List<Account> savingsAccounts,
			List<Account> currentAccounts) {
		// TODO Auto-generated method stub
		CurrentAccount currentAccount = new CurrentAccount(money, name);
		currentAccounts.add(currentAccount);

		boolean isExit = false;
		while (!isExit) {
			System.out.println(
					"Please select the number: \n1.View Balance \n2.Deposit amount \n3.Withdraw \n4.Exit \n5. Create Account");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				double balance = currentAccount.getBalance();
				System.out.println("Balance is " + balance);
				break;
			case 2: {
				System.out.println("Enter the money to be deposited");
				try {

					double money1 = scanner.nextDouble();
					if (money1 < 0)
						throw new CustomException("The deposit amount should be greater than 0");
					currentAccount.depositAmount(money1);
				} catch (CustomException exception) {
					System.out.println(exception.getMessage());
				}
				break;

			}
			case 3: {
				System.out.println("Enter the money to be withdrawn");
				try {
					double money1 = scanner.nextDouble();
					currentAccount.withdrawAmount(money1);
					break;
				} catch (CustomException exception) {
					System.out.println(exception.getMessage());
				}
			}
			case 4: {
				System.out.println("Thank you for working with us");
				System.exit(0);
			}
			case 5: {
				createAcc(scanner, savingsAccounts, currentAccounts);

			}
			default:
				System.out.println("Choose one of the given option");
			}
		}
	}
}

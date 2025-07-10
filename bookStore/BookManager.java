package com.aurionpro.collection.bookStore;

import java.util.*;

public class BookManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		List<Book> books = new ArrayList<>();

		System.out.println("Welcome to Philosopher's Club");
		boolean isWhileTrue = true;
		while (isWhileTrue) {
			System.out.println("Menu");
			System.out.println("------------------");
			System.out.println("1. Add a new book \n2. Get a book" + " \n3. Display all available books "
					+ "\n4. Display all issued books " + "\n5. Return a book \n6. Sort Books"
					+ "\n7. Exit Application");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				addBook(books, scanner);
				break;
			}
			case 2: {
				issueBook(books, scanner);
				break;
			}
			case 3: {
				displayAvailableBooks(books, scanner);
				break;
			}
			case 4: {
				displayIssuedBooks(books, scanner);
				break;
			}
			case 5: {
				returnBook(books, scanner);
				break;
			}
			case 6: {
				sortBooks(books, scanner);
				break;
			}
			case 7: {
				System.out.println("Thank you");
				isWhileTrue = false;
				break;
			}

			default: {
				System.out.println("Please enter a valid choice");
			}

			}
		}
	}

	private static void addBook(List<Book> books, Scanner scanner) {
		System.out.println("Enter the book details as mentioned below: ");
		System.out.println("");
		try {

			System.out.print("Enter the book name: ");
			String name = scanner.next();

			System.out.print("Enter the book author: ");
			String author = scanner.next();

			System.out.print("Enter the book price(only numbers): ");
			double price = scanner.nextInt();

			books.add(new Book(name, author, price, false));
			System.out.println("Book has been added successfully");
		} catch (Exception e) {
			System.err.println("The entered detail should be in their type only");
		}
	}

	private static void issueBook(List<Book> books, Scanner scanner) {
		System.out.print("Enter the bookId which you want to have: ");
		try {
			int bookId = scanner.nextInt();

			for (Book book : books) {
				if (book.getBookId() == bookId) {
					book.setIssued(true);
					System.out.println("The book has been issued");
					return;
				}
				throw new CustomException("Book is not present");
			}
		} catch (CustomException exception) {
			System.out.println(exception.getMessage());
		} catch(Exception exception) {
			System.out.println("the book id should be a number");
		}

	}

	private static void displayAvailableBooks(List<Book> books, Scanner scanner) {
		System.out.println("All the available books are: ");
		for (Book book : books) {
			if (!book.getIssued()) {
				System.out.println(book);
			}

		}
	}

	private static void displayIssuedBooks(List<Book> books, Scanner scanner) {
		System.out.println("All the issued books are: ");
		for (Book book : books) {
			if (book.getIssued()) {
				System.out.println(book);
			}

		}
	}

	private static void returnBook(List<Book> books, Scanner scanner) {
		System.out.print("Enter the bookId which you want to return: ");
		try {

			int bookId = scanner.nextInt();

			for (Book book : books) {
				if (book.getBookId() == bookId) {
					book.setIssued(false);
					System.out.println("The book has been returned");
					return;
				}
				throw new CustomException("Invalid Id");

			}
		} catch (CustomException exception) {
			System.out.println(exception.getMessage());
		} catch (Exception exception) {
			System.out.println("The book id shoulde be a number");
		}
	}

	private static void sortBooks(List<Book> books, Scanner scanner) {
		System.out.println("1.Ascending order of author \n2. Descending order of Title");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			Collections.sort(books, new BookComparator());
			break;
		}
		case 2: {
			Collections.sort(books, new TitleComparator());
		}
		}
	}

}

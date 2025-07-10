package com.aurionpro.collection.bookStore;

public class Book {

	private String name, author;
	private static int bookIdgiver = 00;
	private int bookId;
	private double price;
	private boolean isIssued;
	
	public Book(String name, String author, double price, boolean isIssued) {
		super();
		this.bookId = bookIdgiver+1;
		bookIdgiver++;
		this.name = name;
		this.author = author;
		this.price = price;
		this.isIssued = isIssued;
	}
	public Book() {
		
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", author=" + author + ", bookId=" + bookId + ", price=" + price + ", isIssued="
				+ isIssued + "]";
	}
	
	
	
	
}

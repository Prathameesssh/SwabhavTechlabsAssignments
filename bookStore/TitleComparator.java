package com.aurionpro.collection.bookStore;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o2.getName().compareToIgnoreCase(o1.getName());
	}

}

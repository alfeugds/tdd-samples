package com.dojo2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Book> items;
	public Cart(){
		this.items = new ArrayList<Book>();
	}
	
	public void addItem(Book book){
		items.add(book);
	}

	public List<Book> getItems() {
		return this.items;
	}
}

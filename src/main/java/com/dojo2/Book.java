package com.dojo2;

/**
 * Created by alfeu on 30/05/16.
 */
public class Book implements Comparable<Book>{
    private int type;
    private double price;
    private int quantity;

    public Book(int type, double price, int quantity){
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int compareTo(Book o) {
		return (Double.compare(this.price, o.price));
	}
}

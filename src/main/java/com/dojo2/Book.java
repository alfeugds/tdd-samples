package com.dojo2;

/**
 * Created by alfeu on 30/05/16.
 */
public class Book {
    private int type;
    private double price;

    public Book(int type, double price){
        this.type = type;
        this.price = price;
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
}

package com.dojo2;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfeu on 30/05/16.
 * http://www.codingdojo.org/cgi-bin/index.pl?action=browse&id=KataPotter&revision=41
 */
public class DiscountCalculator {
    private static final double DISCOUNT_FOR_TWO_DIFFERENT_BOOKS = .95;
    private static final double DISCOUNT_FOR_THREE_DIFFERENT_BOOKS = .90;
    private static final double DISCOUNT_FOR_FOUR_DIFFERENT_BOOKS = .80;
    private static final double DISCOUNT_FOR_FIVE_DIFFERENT_BOOKS = .75;

    public static double applyDiscount(List<Book> items) {
    	double sumOfPrices = 0;
    	for(Book item : items){
    		sumOfPrices += item.getPrice();
    	}
        return sumOfPrices * DISCOUNT_FOR_TWO_DIFFERENT_BOOKS;
    }
}

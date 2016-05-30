package com.dojo2;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfeu on 30/05/16.
 * http://www.codingdojo.org/cgi-bin/index.pl?action=browse&id=KataPotter&revision=41
 */
public class DiscountCalculator {
    private static final double BOOK_PRICE = 8;
    private static final double DISCOUNT_FOR_TWO_DIFFERENT_BOOKS = .95;

    public static double applyDiscount(List<Book> basket) {
        return basket.size() * DISCOUNT_FOR_TWO_DIFFERENT_BOOKS * BOOK_PRICE;
    }
}

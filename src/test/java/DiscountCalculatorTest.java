import com.dojo2.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfeu on 30/05/16.
 */
public class DiscountCalculatorTest {
	private double bookPrice = 8;
    @Test
    public void calculateDiscountFor2DifferentBooks(){
        Book book1 = new Book(1, bookPrice, 1);
        Book book2 = new Book(2, bookPrice, 1);
        Cart cart = new Cart();
        cart.addItem(book1);
        cart.addItem(book2);
        double valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 2 * .95,valueWithDiscount);
    }
    
    @Test
    public void calculateSimpleDiscounts(){
        Book book1 = new Book(1, bookPrice, 1);
        Book book2 = new Book(2, bookPrice, 1);
        Book book3 = new Book(3, bookPrice, 1);
        Book book4 = new Book(4, bookPrice, 1);
        Book book5 = new Book(5, bookPrice, 1);
        Cart cart = new Cart();
        cart.addItem(book1);
        cart.addItem(book2);
        double valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 2 * .95,valueWithDiscount);
        
        cart.addItem(book3);
        valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 3 * .9,valueWithDiscount);
        
        cart.addItem(book4);
        valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 4 * .8,valueWithDiscount);
        
        cart.addItem(book5);
        valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 5 * .75,valueWithDiscount);
    }
    
    @Test
    public void calculateDiscountForEqualBooks(){
    	Book book1 = new Book(1, bookPrice, 2);
        Cart cart = new Cart();
        cart.addItem(book1);
        double valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 2,valueWithDiscount);
        
        book1.setQuantity(3);
        valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 3,valueWithDiscount);
        
        book1.setQuantity(4);
        valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(bookPrice * 4,valueWithDiscount);
    }
}

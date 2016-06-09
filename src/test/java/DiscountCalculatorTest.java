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
        Book book1 = new Book(1, bookPrice);
        Book book2 = new Book(2, bookPrice);
        Cart cart = new Cart();
        cart.addItem(book1);
        cart.addItem(book2);
        double valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(15.2d,valueWithDiscount);
    }
    
    @Test
    public void calculateDiscountFor2EqualBooks(){
    	Book book1 = new Book(1, bookPrice);
        Book book2 = new Book(1, bookPrice);
        Cart cart = new Cart();
        cart.addItem(book1);
        cart.addItem(book2);
        double valueWithDiscount = DiscountCalculator.applyDiscount(cart.getItems());
        Assert.assertEquals(16d,valueWithDiscount);
    }
}

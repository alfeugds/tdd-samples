import com.dojo2.Book;
import com.dojo2.DiscountCalculator;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfeu on 30/05/16.
 */
public class DiscountCalculatorTest {
    @Test
    public void calculateDiscountFor2DifferentBooks(){
        Book book1 = new Book(1);
        Book book2 = new Book(2);
        List<Book> basket = new ArrayList<Book>();
        basket.add(book1);
        basket.add(book2);
        double valueWithDiscount = DiscountCalculator.applyDiscount(basket);
        Assert.assertEquals(15.2d,valueWithDiscount);
    }
}

/**
 * Created by alfeu on 18/05/16.
 */

import junit.framework.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void evaluateEmptyExpression(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("");
        Assert.assertEquals(0, result);
    }

    @Test
    public void evaluateSimpleSumExpression(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1 + 1");
        Assert.assertEquals(2, result);
    }

    @Test
    public void evaluateSimpleSubtractExpression(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("5 - 2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void evaluateSimpleMultiplyExpression(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("5 * 2");
        Assert.assertEquals(10, result);
    }

    @Test
    public void evaluateExpressionWithThreeNumbers(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("2 * 4 + 7");
        Assert.assertEquals(15, result);
    }

    @Test
    public void evaluateExpressionWithParenthesis(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3 * ( 2 + 5 )");
        Assert.assertEquals(21, result);
    }

    @Test
    public void evaluateExpressionWithParenthesis2(){
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3 * ( 2 + 5 * 2)");
        Assert.assertEquals(36, result);
    }

}

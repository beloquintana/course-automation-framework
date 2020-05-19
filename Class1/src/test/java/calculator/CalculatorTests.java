package calculator;

import maths.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests {

    @Test
    public void testSum(){
        Calculator calculator = new Calculator(5, 10);
        Assert.assertEquals(calculator.sum(), 15);
    }

    @Test
    public void testSubtract(){
        Calculator calculator = new Calculator(5, 10);
        Assert.assertEquals(calculator.subtract(), -5);
    }

    @Test
    public void testMultiply(){
        Calculator calculator = new Calculator(5, 10);
        Assert.assertEquals(calculator.multiply(), 50);
    }

    @Test
    public void testDiv(){
        Calculator calculator = new Calculator(5, 10);
        Assert.assertEquals(calculator.div(), 0);
    }
}

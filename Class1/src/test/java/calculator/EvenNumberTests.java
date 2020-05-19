package calculator;

import maths.EvenNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EvenNumberTests {

    @Test
    public void testIsEvenNumber(){
        EvenNumber evenNumber = new EvenNumber();
        Assert.assertTrue(evenNumber.isEvenNumber(4));
    }

    @Test
    public void testIsNotEvenNumber(){
        EvenNumber evenNumber = new EvenNumber();
        Assert.assertFalse(evenNumber.isEvenNumber(5));
    }
}

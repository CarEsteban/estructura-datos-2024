import org.junit.Assert;
import org.junit.Test;

import src.calculator;

public class calculatorTest {
    @Test
    public void testAdd() {
        int num1 = 3;
        int num2 = 4;
        calculator myCalc = new calculator();
        Assert.assertEquals(7, myCalc.add(num1, num2));
    }
}

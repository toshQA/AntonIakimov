package com.epam.tc.hw1;

import org.testng.Assert;
import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

public class CalcSumTest extends CalculatorBaseTest {

    @Test
    public void sumTest() {
        Calculator calculator = new Calculator();
        double actual = calculator.sum(2, 5);
        Assert.assertEquals(actual, 7);
    }
}

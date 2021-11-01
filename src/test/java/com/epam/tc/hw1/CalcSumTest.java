package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcSumTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][] {
            {3, 2, 5},
            {5, 5, 10},
            {300, 120, 420}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void sumTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcMultipleTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] multipleDataProvider() {
        return new Object[][] {
            {3, 2, 6},
            {10, 5, 50},
            {300, 120, 36000}
        };
    }

    @Test(dataProvider = "multipleDataProvider")
    public void multipleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcDivideTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] divideDataProvider() {
        return new Object[][] {
            {4, 2, 2},
            {10, 5, 2},
            {300, 100, 3}
        };
    }

    @Test(dataProvider = "divideDataProvider")
    public void divideTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

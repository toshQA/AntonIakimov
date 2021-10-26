package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcSubtractTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] subtractDataProvider() {
        return new Object[][] {
            {3, 2, 1},
            {10, 5, 5},
            {300, 120, 180}
        };
    }

    @Test(dataProvider = "subtractDataProvider")
    public void subtractTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

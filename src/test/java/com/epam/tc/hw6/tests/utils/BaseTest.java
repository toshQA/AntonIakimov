package com.epam.tc.hw6.tests.utils;

import com.epam.tc.hw6.sections.Header;
import com.epam.tc.hw6.utils.WebDriverProvider;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver webDriver;
    protected SoftAssert softAssert;
    protected Header header;

    public BaseTest() {
        header = new Header(webDriver);
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        softAssert = new SoftAssert();
        webDriver = WebDriverProvider.getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("webDriver", webDriver);

    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.closeWebDriver();
    }
}

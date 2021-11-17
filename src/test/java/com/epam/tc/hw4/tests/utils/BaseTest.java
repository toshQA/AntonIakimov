package com.epam.tc.hw4.tests.utils;

import com.epam.tc.hw4.sections.Header;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
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
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("webDriver", webDriver);

    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

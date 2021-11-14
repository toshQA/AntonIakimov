package com.epam.tc.hw4.tests.utils;

import com.epam.tc.hw4.sections.Header;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    public void assertHomePageURL() {
        softAssert.assertEquals(webDriver.getCurrentUrl(),
            TestProperties.getTestProperties().getProperty("homePageURL"));
    }

    public void assertHomePageTitle() {
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));
    }

    public void performLogin() {
        header.login();
    }

    public void assertUsernameIsLoggined() {
        softAssert.assertEquals(header.getUserName(),
            TestProperties.getTestProperties().getProperty("fullName"));
    }
}

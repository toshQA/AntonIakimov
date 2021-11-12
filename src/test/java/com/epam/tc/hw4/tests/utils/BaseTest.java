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

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(TestProperties.getTestProperties().getProperty("homePageURL"));

        header = new Header(webDriver);
        // 1. Open test site by URL
        assertHomePageURL();
        // 2. Assert Browser title
        assertHomePageTitle();
        // 3, 4. Perform login and assert Username is loggined
        performLogin();
        assertUsernameIsLoggined();
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

package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver webDriver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(TestProperties.getTestProperties().getProperty("homePageURL"));

    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    protected void assertHomePageURL() {
        String actualURL = webDriver.getCurrentUrl();
        softAssert.assertEquals(actualURL, TestProperties.getTestProperties().getProperty("homePageURL"));
    }

    protected void assertHomePageTitle() {
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));
    }

    protected void assertUserIsLoggined() {
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(TestProperties.getTestProperties().getProperty("login"));
        webDriver.findElement(By.id("password")).sendKeys(TestProperties.getTestProperties().getProperty("password"));
        webDriver.findElement(By.id("login-button")).click();

        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

}

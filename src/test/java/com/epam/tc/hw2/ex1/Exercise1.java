package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import com.epam.tc.hw2.DataClass;
import com.epam.tc.hw2.TestProperties;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @Test
    public void excercise1() {
        // 1. Open test site by URL
        String actualURL = webDriver.getCurrentUrl();
        softAssert.assertEquals(actualURL, TestProperties.getTestProperties().getProperty("homePageURL"));

        // 2. Assert Browser title
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));

        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(TestProperties.getTestProperties().getProperty("login"));
        webDriver.findElement(By.id("password")).sendKeys(TestProperties.getTestProperties().getProperty("password"));
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> actualHeaderNavBarItems =
            webDriver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertHeaderNavBarItemText(actualHeaderNavBarItems);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriver.findElements(By.className("icons-benefit"));
        assertImagesOnTheHomePage(images);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = webDriver.findElements(By.className("benefit-txt"));
        assertTextsUnderImagesOnTheHomePage(texts);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.id("frame")));
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        webDriver.switchTo().parentFrame();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> actualSideNavBarItems =
            webDriver.findElements(By.xpath("//ul[@class='sidebar-menu left']/li/a/span"));
        assertSideNavBarItemText(actualSideNavBarItems);

        softAssert.assertAll();
    }

    private void assertHeaderNavBarItemText(List<WebElement> actualHeaderNavBarItems) {
        for (int i = 0; i < actualHeaderNavBarItems.size(); i++) {
            softAssert.assertEquals(actualHeaderNavBarItems.get(i).getText(),
                DataClass.expectedHeaderNavBarItemTexts.get(i));
        }
    }

    private void assertImagesOnTheHomePage(List<WebElement> images) {
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }
    }

    private void assertTextsUnderImagesOnTheHomePage(List<WebElement> texts) {
        for (int i = 0; i < texts.size(); i++) {
            softAssert.assertEquals(texts.get(i).getText(), DataClass.expectedTextsUnderTheImages.get(i));
        }
    }

    private void assertSideNavBarItemText(List<WebElement> actualSideNavBarItems) {
        for (int i = 0; i < actualSideNavBarItems.size(); i++) {
            softAssert.assertEquals(actualSideNavBarItems.get(i).getText(),
                DataClass.expectedSideNavBarItemTexts.get(i));
        }
    }
}

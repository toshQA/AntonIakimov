package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @Test
    public void excercise1() {
        // 1. Open test site by URL
        String expectedURL = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(expectedURL);
        String actualURL = webDriver.getCurrentUrl();
        softAssert.assertEquals(actualURL, expectedURL);

        // 2. Assert Browser title
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));

        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(webDriver.findElement(By.linkText("HOME")).getText(), "HOME");
        softAssert.assertTrue(webDriver.findElement(By.linkText("HOME")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        softAssert.assertTrue(webDriver.findElement(By.linkText("CONTACT FORM")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        softAssert.assertTrue(webDriver.findElement(By.linkText("SERVICE")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");
        softAssert.assertTrue(webDriver.findElement(By.linkText("METALS & COLORS")).isDisplayed());

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriver.findElements(By.className("icons-benefit"));
        for (int i = 0; i < images.size(); i++) {
            softAssert.assertTrue(images.get(i).isDisplayed());
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = webDriver.findElements(By.className("benefit-txt"));
        for (int i = 0; i < texts.size(); i++) {
            softAssert.assertTrue(images.get(i).isDisplayed());
        }
        softAssert.assertEquals(texts.get(0).getText(), "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");

        softAssert.assertEquals(texts.get(1).getText(), "To be flexible and\n"
            + "customizable");

        softAssert.assertEquals(texts.get(2).getText(), "To be multiplatform");

        softAssert.assertEquals(texts.get(3).getText(), "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.id("frame")));
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        webDriver.switchTo().parentFrame();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(), 'Home')]"))
                                         .getText(), "Home");
        softAssert.assertTrue(webDriver.findElement(By.xpath("//span[contains(text(), 'Home')]")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(), 'Contact form')]"))
                                         .getText(), "Contact form");
        softAssert.assertTrue(webDriver.findElement(By.xpath("//span[contains(text(), 'Contact form')]"))
                                       .isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(), 'Service')]"))
                                         .getText(), "Service");
        softAssert.assertTrue(webDriver.findElement(By.xpath("//span[contains(text(), 'Service')]")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(), 'Metals & Colors')]"))
                                         .getText(), "Metals & Colors");
        softAssert.assertTrue(webDriver.findElement(By.xpath("//span[contains(text(), 'Metals & Colors')]"))
                                       .isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(), 'Elements packs')]"))
                                         .getText(), "Elements packs");
        softAssert.assertTrue(webDriver.findElement(By.xpath("//span[contains(text(), 'Elements packs')]"))
                                       .isDisplayed());

        softAssert.assertAll();

    }
}

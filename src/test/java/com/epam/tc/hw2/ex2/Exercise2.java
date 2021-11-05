package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import com.epam.tc.hw2.TestProperties;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    @Test
    public void exercise2() {
        // 1. Open test site by URL
        assertHomePageURL();

        // 2. Assert Browser title
        assertHomePageTitle();

        // 3, 4. Perform login and assert Username is loggined
        assertUserIsLoggined();

        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.linkText("SERVICE")).click();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        softAssert.assertEquals(webDriver.getCurrentUrl(),
            TestProperties.getTestProperties().getProperty("differentElementsPageURL"));

        // 6. Select checkboxes
        webDriver.findElement(By.xpath("//label[contains(., 'Water')]/input")).click();
        webDriver.findElement(By.xpath("//label[contains(., 'Wind')]/input")).click();

        // 7. Select radio
        webDriver.findElement(By.xpath("//label[contains(., 'Selen')]/input")).click();

        // 8. Select in dropdown
        webDriver.findElement(By.className("colors")).click();
        webDriver.findElement(By.xpath("//option[text()='Yellow']")).click();

        // 9. Assert data from logs
        WebElement logsTable = webDriver.findElement(By.className("logs"));
        List<WebElement> logsTexts = logsTable.findElements(By.tagName("li"));
        softAssert.assertTrue(logsTexts.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logsTexts.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logsTexts.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logsTexts.get(3).getText().contains("Water: condition changed to true"));

        softAssert.assertAll();

    }
}

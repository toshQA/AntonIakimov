package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import com.epam.tc.hw2.DataClass;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @Test
    public void excercise1() {
        // 1. Open test site by URL
        assertHomePageURL();

        // 2. Assert Browser title
        assertHomePageTitle();

        // 3, 4. Perform login and assert Username is loggined
        assertUserIsLoggined();

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> actualHeaderNavBarItems =
            webDriver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li/a"));
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
        softAssert.assertEquals(actualHeaderNavBarItems.size(), DataClass.EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS.size());
        List<String> actualHeaderNavBarItemsTextsList = new ArrayList<>();
        for (WebElement actualHeaderNavBarItemsText : actualHeaderNavBarItems) {
            actualHeaderNavBarItemsTextsList.add(actualHeaderNavBarItemsText.getText());
        }
        softAssert.assertTrue(actualHeaderNavBarItemsTextsList
            .containsAll(DataClass.EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS));
    }

    private void assertImagesOnTheHomePage(List<WebElement> images) {
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }
    }

    private void assertTextsUnderImagesOnTheHomePage(List<WebElement> texts) {
        softAssert.assertEquals(texts.size(), DataClass.EXPECTED_TEXTS_UNDER_THE_IMAGES.size());
        List<String> textsUnderImagesList = new ArrayList<>();
        for (WebElement textUnderImage : texts) {
            textsUnderImagesList.add(textUnderImage.getText());
        }
        softAssert.assertTrue(textsUnderImagesList.containsAll(DataClass.EXPECTED_TEXTS_UNDER_THE_IMAGES));
    }

    private void assertSideNavBarItemText(List<WebElement> actualSideNavBarItems) {
        softAssert.assertEquals(actualSideNavBarItems.size(), DataClass.EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS.size());
        List<String> actualSideNavBarItemsTextsList = new ArrayList<>();
        for (WebElement actualSideNavBarItemsText : actualSideNavBarItems) {
            actualSideNavBarItemsTextsList.add(actualSideNavBarItemsText.getText());
        }
        softAssert.assertTrue(actualSideNavBarItemsTextsList.containsAll(DataClass.EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS));
    }
}

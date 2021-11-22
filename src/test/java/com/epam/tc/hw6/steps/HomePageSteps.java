package com.epam.tc.hw6.steps;

import static com.epam.tc.hw6.tests.utils.DataClass.EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS;
import static com.epam.tc.hw6.tests.utils.DataClass.EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS;
import static com.epam.tc.hw6.tests.utils.DataClass.EXPECTED_TEXTS_UNDER_THE_IMAGES;
import static com.epam.tc.hw6.tests.utils.TestProperties.getProperty;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSteps extends BasePageSteps {

    public HomePageSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert incorrect Home Page title")
    public HomePageSteps assertIncorrectHomePageTitle() {
        softAssert.assertTrue(homePage.getDriver().getTitle().contains("Test Page"));
        return this;
    }

    @Step("Assert header navbar items")
    public HomePageSteps assertHeaderNavBarItems() {
        List<WebElement> actualHeaderNavBarItems = homePage.getHeader().getActualHeaderNavBarItems();
        List<String> actualHeaderNavBarItemsTexts = homePage.getHeader()
                                                            .getActualHeaderNavBarItemsTexts(actualHeaderNavBarItems);
        softAssert.assertEquals(actualHeaderNavBarItems.size(), EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS.size());
        softAssert.assertTrue(actualHeaderNavBarItemsTexts.containsAll(EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS));
        return this;
    }

    @Step("Assert quantity of images on Home Page")
    public HomePageSteps assertQuantityOfImages() {
        softAssert.assertEquals(homePage.getImages().size(), Integer.parseInt(getProperty("imagesQuantity")));
        return this;
    }

    @Step("Assert texts under the images on Home Page")
    public HomePageSteps assertTextsUnderTheImages() {
        List<WebElement> texts = homePage.getTexts();
        List<String> actualTexts = homePage.getActualTexts(texts);

        softAssert.assertEquals(texts.size(), EXPECTED_TEXTS_UNDER_THE_IMAGES.size());
        softAssert.assertTrue(actualTexts.containsAll(EXPECTED_TEXTS_UNDER_THE_IMAGES));
        return this;
    }

    @Step("Assert iframe button in iframe")
    public HomePageSteps assertIFrameButton() {
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());
        return this;
    }

    @Step("Switch to parent frame")
    public HomePageSteps switchToParentFrame() {
        homePage.switchToParentFrame();
        return this;
    }

    @Step("Assert side nav bar items")
    public HomePageSteps assertSideNavBarItems() {
        List<WebElement> actualSideNavBarItems = homePage.getLeftSideMenu().getActualSideNavBarItems();
        List<String> actualSideNavBarItemsTexts = homePage.getLeftSideMenu()
                                                          .getActualSideNavBarItemsTexts(actualSideNavBarItems);
        softAssert.assertEquals(actualSideNavBarItems.size(), EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS.size());
        softAssert.assertTrue((actualSideNavBarItemsTexts).containsAll(EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS));
        return this;
    }

    @Step("Assert All")
    public void assertAll() {
        softAssert.assertAll();
    }
}

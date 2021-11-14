package com.epam.tc.hw4.steps;

import static com.epam.tc.hw3.tests.utils.DataClass.EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS;
import static com.epam.tc.hw3.tests.utils.DataClass.EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS;
import static com.epam.tc.hw3.tests.utils.DataClass.EXPECTED_TEXTS_UNDER_THE_IMAGES;

import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.tests.utils.BaseTest;
import com.epam.tc.hw4.tests.utils.TestProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePageSteps {
    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected BaseTest baseTest;

    public HomePageSteps(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        softAssert = new SoftAssert();
    }

    @Step("Open Home Page")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Step("Assert Home Page title")
    public void assertHomePageTitle() {
        softAssert.assertTrue(homePage.getDriver().getTitle().contains("Home Page"));
    }

    @Step("Assert incorrect Home Page title")
    public void assertIncorrectHomePageTitle() {
        softAssert.assertTrue(homePage.getDriver().getTitle().contains("Test Page"));
    }

    @Step("Perform Login")
    public void performLogin() {
        homePage.getHeader().login();
    }

    @Step("Assert Username")
    public void assertUsername() {
        softAssert.assertEquals(homePage.getHeader().getUserName(),
            TestProperties.getTestProperties().getProperty("fullName"));
    }

    @Step("Assert header navbar items")
    public void assertHeaderNavBarItems() {
        softAssert.assertEquals(homePage.getHeader().getActualHeaderNavBarItems().size(),
            EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS.size());
        softAssert.assertTrue(homePage.getHeader().getActualHeaderNavBarItemsTexts(homePage
                                          .getHeader().getActualHeaderNavBarItems())
                                      .containsAll(EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS));
    }

    @Step("Assert quantity of images on Home Page")
    public void assertQuantityOfImages() {
        softAssert.assertEquals(homePage.getImages().size(),
            Integer.parseInt(TestProperties.getTestProperties().getProperty("imagesQuantity")));
    }

    @Step("Assert texts under the images on Home Page")
    public void assertTextsUnderTheImages() {
        softAssert.assertEquals(homePage.getTexts().size(), EXPECTED_TEXTS_UNDER_THE_IMAGES.size());
        softAssert.assertTrue(homePage.getActualTexts(homePage.getTexts())
                                      .containsAll(EXPECTED_TEXTS_UNDER_THE_IMAGES));
    }

    @Step("Assert iframe button in iframe")
    public void assertIFrameButton() {
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("Switch to parent frame")
    public void switchToParentFrame() {
        homePage.switchToParentFrame();
    }

    @Step("Assert side nav bar items")
    public void assertSideNavBarItems() {
        softAssert.assertEquals(homePage.getLeftSideMenu().getActualSideNavBarItems().size(),
            EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS.size());
        softAssert.assertTrue(homePage.getLeftSideMenu().getActualSideNavBarItemsTexts(homePage
                                          .getLeftSideMenu().getActualSideNavBarItems())
                                      .containsAll(EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS));
    }

    public void assertAll() {
        softAssert.assertAll();
    }

}

package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.steps.HomePageSteps;
import com.epam.tc.hw4.tests.utils.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Feature("Allure report for Home page")
    @Story("Allure reporting training")
    @Test
    public void homePageTest() {
        HomePageSteps homePageSteps = new HomePageSteps(webDriver);

        homePageSteps.openHomePage()
                     .assertHomePageTitle()
                     .performLogin()
                     .assertUsername();
        homePageSteps.assertHeaderNavBarItems()
                     .assertQuantityOfImages()
                     .assertTextsUnderTheImages()
                     .assertIFrameButton()
                     .switchToParentFrame()
                     .assertSideNavBarItems()
                     .assertAll();

    }
}

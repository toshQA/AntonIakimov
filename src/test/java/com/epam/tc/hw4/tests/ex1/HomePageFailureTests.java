package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.steps.HomePageSteps;
import com.epam.tc.hw4.tests.utils.BaseTest;
import com.epam.tc.hw4.tests.utils.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class HomePageFailureTests extends BaseTest {

    @Feature("Allure report for Home page")
    @Story("Allure reporting training with failure test")
    @Test
    public void homePageFailureTest() {
        HomePageSteps homePageSteps = new HomePageSteps(webDriver);

        homePageSteps.openHomePage();
        homePageSteps.assertIncorrectHomePageTitle();
        homePageSteps.performLogin();
        homePageSteps.assertUsername();
        homePageSteps.assertHeaderNavBarItems();
        homePageSteps.assertQuantityOfImages();
        homePageSteps.assertTextsUnderTheImages();
        homePageSteps.assertIFrameButton();
        homePageSteps.switchToParentFrame();
        homePageSteps.assertSideNavBarItems();
        homePageSteps.assertAll();
    }
}

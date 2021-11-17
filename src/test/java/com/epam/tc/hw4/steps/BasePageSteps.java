package com.epam.tc.hw4.steps;

import static com.epam.tc.hw4.tests.utils.TestProperties.getProperty;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BasePageSteps {

    protected SoftAssert softAssert;
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;

    public BasePageSteps(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        softAssert = new SoftAssert();
    }

    @Step("Open Home Page")
    public BasePageSteps openHomePage() {
        homePage.openHomePage(getProperty("homePageURL"));
        return this;
    }

    @Step("Assert Home Page title")
    public BasePageSteps assertHomePageTitle() {
        softAssert.assertTrue(homePage.getDriver().getTitle().contains("Home Page"));
        return this;
    }

    @Step("Perform Login")
    public BasePageSteps performLogin() {
        homePage.getHeader().login(getProperty("login"), getProperty("password"));
        return this;
    }

    @Step("Assert Username")
    public BasePageSteps assertUsername() {
        softAssert.assertEquals(homePage.getHeader().getUserName(), getProperty("fullName"));
        return this;
    }

}

package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw7.SiteJDI.homePage;
import static com.epam.tc.hw7.states.States.loggedIn;

import com.epam.tc.hw7.SiteJDI;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public interface TestInit {

    @BeforeMethod
    static void setUp() {
        initElements(SiteJDI.class);
        loggedIn();
        homePage.shouldBeOpened();
    }

    @AfterMethod
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}

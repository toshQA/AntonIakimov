package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;

public abstract class AbstractBaseStep {
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractBaseStep() {
        homePage = new HomePage(CucumberHooks.webDriver);
        differentElementsPage = new DifferentElementsPage(CucumberHooks.webDriver);
        userTablePage = new UserTablePage(CucumberHooks.webDriver);
    }
}

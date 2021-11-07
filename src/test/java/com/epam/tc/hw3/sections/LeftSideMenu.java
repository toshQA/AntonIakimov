package com.epam.tc.hw3.sections;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSideMenu {
    @FindBy(xpath = "//span[text() = 'Home']")
    private WebElement homeSideBarTab;

    @FindBy(xpath = "//span[text() = 'Contact form']")
    private WebElement contactFormSideBarTab;

    @FindBy(xpath = "//span[text() = 'Service']")
    private WebElement serviceSideBarTab;

    @FindBy(xpath = "//span[text() = 'Metals & Colors']")
    private WebElement metalsAndColorsSideBarTab;

    @FindBy(xpath = "//span[text() = 'Elements packs']")
    private WebElement elementsSideBarTab;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li/a/span")
    private List<WebElement> actualSideNavBarItems;

    public List<WebElement> getActualSideNavBarItems() {
        return actualSideNavBarItems;
    }

    public LeftSideMenu(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}

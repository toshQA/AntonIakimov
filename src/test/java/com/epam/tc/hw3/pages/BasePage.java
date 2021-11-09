package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.sections.Header;
import com.epam.tc.hw3.sections.LeftSideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected Header header;
    protected LeftSideMenu leftSideMenu;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        header = new Header(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }

}

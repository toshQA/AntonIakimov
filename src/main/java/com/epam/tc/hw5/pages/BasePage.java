package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.sections.Header;
import com.epam.tc.hw5.sections.LeftSideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected Header header;
    protected LeftSideMenu leftSideMenu;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        header = new Header(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
    }

    public WebDriver getDriver() {
        return webDriver;
    }
}

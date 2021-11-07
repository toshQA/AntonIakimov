package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.sections.Header;
import com.epam.tc.hw3.sections.LeftSideMenu;
import com.epam.tc.hw3.tests.utils.BaseTest;
import com.epam.tc.hw3.tests.utils.DataClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    protected Header header;
    protected LeftSideMenu leftSideMenu;

    @FindBy(className = "icons-benefit")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> texts;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        header = new Header(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
    }

    public Header getHeader() {
        return header;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public void switchToFrame(WebDriver webDriver) {
        webDriver.switchTo().frame(frame);
    }

    public void switchToParentFrame(WebDriver webDriver) {
        webDriver.switchTo().parentFrame();
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

}

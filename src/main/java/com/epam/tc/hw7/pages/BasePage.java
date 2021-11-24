package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.sections.Header;

public class BasePage extends WebPage {

    @UI(".uui-header dark-gray")
    public Header header;
}

package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.utils.HeaderTabs;

@UI(".uui-header dark-gray")
public class Header extends Section {

    @UI(".uui-navigation navbar-nav navbar-right")
    public LoginMenu loginMenu;

    @UI(".uui-navigation nav navbar-nav m-l8")
    public HeaderNavBar headerNavBar;

    public void openPage(HeaderTabs headerTabs) {
        headerNavBar.getHeaderTabs().select(headerTabs.getHeaderTab());
    }

}

package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

@UI(".uui-navigation nav navbar-nav m-l8")
public class HeaderNavBar {

    @UI(".uui-navigation.nav.navbar-nav.m-l8 li")
    public static Menu headerTabs;

    public Menu getHeaderTabs() {
        return headerTabs;
    }
}

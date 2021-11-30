package com.epam.tc.hw7;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.MetalsAndColorsPage;
import com.epam.tc.hw7.sections.forms.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJDI {
    
    public static LoginForm loginForm;

    @Url("/index.html")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    @UI("#user-icon")
    public static UIElement userIcon;

    @UI("#user-name")
    public static UIElement userName;

}

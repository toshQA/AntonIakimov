package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.SiteJDI.homePage;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.utils.HeaderTabs;
import org.testng.annotations.Test;

public class MetalsAndColorPageTests implements TestInit {

    @Test
    public void openMetalsAndColorsPage() {
        homePage.header.openPage(HeaderTabs.MetalsAndColors);
        WebPage.checkUrl("https://jdi-testing.github.io/jdi-light/metals-colors.html");
    }




}

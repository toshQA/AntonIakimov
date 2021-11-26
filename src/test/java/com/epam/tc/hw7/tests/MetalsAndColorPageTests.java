package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.SiteJDI.homePage;
import static com.epam.tc.hw7.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.tc.hw7.pages.MetalsAndColorsPage.results;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.entities.MetalsAndColors;
import com.epam.tc.hw7.utils.HeaderTabs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MetalsAndColorPageTests implements TestInit {

    @BeforeMethod
    public void openMetalsAndColorsPage() {
        homePage.header.openPage(HeaderTabs.MetalsAndColors);
        WebPage.checkUrl("https://jdi-testing.github.io/jdi-light/metals-colors.html");
    }

    @Test(dataProviderClass = MetalsAndColorsDataProvider.class, dataProvider = "Metals And Colors Provider")
    public void submitMetalsAndColorsFormTest(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fill(metalsAndColors);
        metalsAndColorsForm.submit();
        assertThat(results.getResults()).isEqualTo(metalsAndColors.toListString());
    }


}

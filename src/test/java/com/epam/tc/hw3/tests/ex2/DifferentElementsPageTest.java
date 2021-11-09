package com.epam.tc.hw3.tests.ex2;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.tests.utils.BaseTest;
import com.epam.tc.hw3.tests.utils.TestProperties;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test
    public void differentElementsPageTest() {
        HomePage homePage = new HomePage(webDriver);

        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
        homePage
            .getHeader()
            .openDifferentElementsPage();
        softAssert.assertEquals(webDriver.getCurrentUrl(),
            TestProperties.getTestProperties().getProperty("differentElementsPageURL"));

        // 6. Select checkboxes
        differentElementsPage.selectCheckboxes();

        // 7. Select radio
        differentElementsPage.selectRadioButton();

        // 8. Select in dropdown
        differentElementsPage.selectYellowItemInColorDropdown();

        // 9. Assert data from logs
        softAssert.assertTrue(differentElementsPage.getLogsList()
                                                   .get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(differentElementsPage.getLogsList()
                                                   .get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(differentElementsPage.getLogsList()
                                                   .get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.getLogsList()
                                                   .get(3).getText().contains("Water: condition changed to true"));
        softAssert.assertAll();

    }
}

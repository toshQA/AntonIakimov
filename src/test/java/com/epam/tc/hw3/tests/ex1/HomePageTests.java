package com.epam.tc.hw3.tests.ex1;

import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.tests.utils.BaseTest;
import com.epam.tc.hw3.tests.utils.DataClass;
import com.epam.tc.hw3.tests.utils.TestProperties;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void homePageTest() {

        HomePage homePage = new HomePage(webDriver);

        // 1. Open test site by URL
        assertHomePageURL();

        // 2. Assert Browser title
        assertHomePageTitle();

        // 3, 4. Perform login and assert Username is loggined
        homePage.getHeader().login();
        softAssert.assertEquals(homePage.getHeader().getUserName(),
            TestProperties.getTestProperties().getProperty("fullName"));

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(homePage.getHeader().getActualHeaderNavBarItems().size(),
            DataClass.EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS.size());
        homePage.getHeader().getActualHeaderNavBarItems().containsAll(DataClass.EXPECTED_HEADER_NAV_BAR_ITEM_TEXTS);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.getImages().size(),
            Integer.parseInt(TestProperties.getTestProperties().getProperty("imagesQuantity")));

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(homePage.getTexts().size(), DataClass.EXPECTED_TEXTS_UNDER_THE_IMAGES.size());
        homePage.getTexts().containsAll(DataClass.EXPECTED_TEXTS_UNDER_THE_IMAGES);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame(webDriver);
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        homePage.switchToParentFrame(webDriver);

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(homePage.getLeftSideMenu().getActualSideNavBarItems().size(),
            DataClass.EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS.size());
        homePage.getLeftSideMenu().getActualSideNavBarItems().containsAll(DataClass.EXPECTED_SIDE_NAV_BAR_ITEM_TEXTS);

        softAssert.assertAll();

    }

}

package com.picsart.ui.tests.search;


import com.picsart.ui.pages.ImagePage;
import com.picsart.ui.pages.SearchPage;
import com.picsart.ui.tests.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {
    private SoftAssert softAssert;
    private SearchPage searchPage;
    private ImagePage imagePage;

    @BeforeMethod
    public void init() {
        softAssert = new SoftAssert();
        searchPage = new SearchPage(driver);
        imagePage = new ImagePage(driver);
    }

    @Test
    public void searchFilterTest() {
        boolean isFilterVisible = searchPage
                .open()
                .acceptCookies()
                .clickOnFilterButton()
                .isFilterToolbarVisible();

        assertFalse(isFilterVisible, "Filter toolbar should not be visible");

        searchPage.clickOnFilterButton();
        boolean plusBadgeVisible = searchPage.isPlusBadgeVisible();
        assertTrue(plusBadgeVisible, "Plus badges should be visible");

        searchPage.checkPersonalFilter();
        boolean plusBadgeInvisible = searchPage.isPlusBadgeInvisible();
        assertTrue(plusBadgeInvisible, "Plus badges should be hidden");

        searchPage.clickOnFirstImage();
        softAssert.assertTrue(imagePage.isImageLikedButtonVisible(), "Like button should be visible");
        softAssert.assertTrue(imagePage.isSaveButtonVisible(), "Save button should be visible");
        softAssert.assertTrue(imagePage.isEditThisImageButtonVisible(), "Edit button should be visible");
        softAssert.assertAll();


        System.out.println("debug");

    }


}

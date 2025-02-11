package com.picsart.ui.tests.search;


import com.picsart.ui.components.SignInPopup;
import com.picsart.ui.pages.EditorPage;
import com.picsart.ui.pages.ImagePage;
import com.picsart.ui.pages.SearchPage;
import com.picsart.ui.tests.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {
    private SoftAssert softAssert;
    private SearchPage searchPage;
    private ImagePage imagePage;
    private SignInPopup signInPopup;
    private EditorPage editorPage;

    @BeforeMethod
    public void init() {
        softAssert = new SoftAssert();
        searchPage = new SearchPage(driver);
        imagePage = new ImagePage(driver);
        signInPopup = new SignInPopup(driver);
        editorPage = new EditorPage(driver);
    }

    @Test
    public void searchFilterTest() {
        boolean isFilterInvisible = searchPage
                .open()
                .acceptCookies()
                .clickOnFilterButton()
                .isFilterToolbarInvisible();

        assertTrue(isFilterInvisible, "Filter toolbar should not be visible");

        searchPage.clickOnFilterButton();
        assertTrue(searchPage.isPlusBadgeVisible(), "Plus badges should be visible");

        searchPage.checkPersonalFilter();
        assertTrue(searchPage.isPlusBadgeInvisible(), "Plus badges should be hidden");

        searchPage.clickOnFirstImage();
        softAssert.assertTrue(imagePage.isImageLikedButtonVisible(), "Like button should be visible");
        softAssert.assertTrue(imagePage.isSaveButtonVisible(), "Save button should be visible");
        softAssert.assertTrue(imagePage.isEditThisImageButtonVisible(), "Edit button should be visible");
        softAssert.assertAll();

        imagePage.clickOnLikeButton();
        assertTrue(signInPopup.isSignInPopupVisible(), "Sign in popup should be visible");

        signInPopup.closeSignInPopup();
        imagePage.goBack();
        searchPage.uncheckPersonalFilter();
        searchPage.scrollDownToImagesSection();
        String firstImageLink = searchPage.getFirstPlusImageLink();
        searchPage.clickOnFirstPlusImage();
        signInPopup.closeSignInPopup();
        softAssert.assertTrue(editorPage.isEditorToolbarVisible(), "Editor toolbar should be visible");
        softAssert.assertTrue(editorPage.isCanvasVisible(), "Canvas should be visible");
        softAssert.assertEquals(firstImageLink, searchPage.getCurrentUrl(), "Current url should be the same as image link");
        softAssert.assertAll();
    }


}

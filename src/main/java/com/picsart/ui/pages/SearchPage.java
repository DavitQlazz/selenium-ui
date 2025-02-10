package com.picsart.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage<SearchPage> {
    private final String SEARCH_PAGE_PATH = baseUrl + "search/";

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    @FindBy(css = "[data-testid='search-header-filter']")
    private WebElement filterBtn;

    @FindBy(css = "[data-testid='search-filter-root']")
    private WebElement searchFilterToolbar;

    @FindBy(css = "iframe[data-testid='com.picsart.social.search']")
    private WebElement iframeSocialSearch;

    @FindBy(css = "[aria-label='licenses-Personal-checkbox']")
    private WebElement personalFilterCheckBoxCheck;

    @FindBy(css = "[aria-label='licenses-Personal'] label")
    private WebElement personalFilterCheckBoxUncheck;

    @FindBy(css = "i[data-testid='badge']")
    private WebElement plusBadge;

    @FindBy(css = "[data-testid='search-card-root']:has([data-testid='badge'])")
    private WebElement plusAsset;

    @FindBy(css = "[data-testid='base-card-link']")
    private WebElement image;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open search page")
    public SearchPage open() {
        open(SEARCH_PAGE_PATH);
        return this;
    }

    @Step
    public SearchPage acceptCookies() {
        click(acceptAllCookiesBtn);
        switchToFrame(iframeSocialSearch);
        return this;
    }

    @Step
    public SearchPage clickOnFilterButton() {
        click(filterBtn);
        return this;
    }

    @Step
    public void clickOnFirstImage() {
        click(image);
    }

    @Step
    public void clickOnFirstPlusAsset() {
        click(plusAsset);
    }

    @Step
    public SearchPage checkPersonalFilter() {
        click(personalFilterCheckBoxCheck);
        return this;
    }

    @Step
    public SearchPage uncheckPersonalFilter() {
        switchToFrame(iframeSocialSearch);
        click(personalFilterCheckBoxUncheck);
        return this;
    }

    @Step
    public boolean isFilterToolbarInvisible() {
        return isInvisible(searchFilterToolbar);
    }

    @Step
    public boolean isPlusBadgeVisible() {
        return isVisible(plusBadge);
    }

    @Step
    public boolean isPlusBadgeInvisible() {
        return isInvisible(plusBadge);
    }
}
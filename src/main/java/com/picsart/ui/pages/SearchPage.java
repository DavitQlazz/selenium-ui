package com.picsart.ui.pages;

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
    private WebElement personalFilterCheckBox;

    @FindBy(css = "i[data-testid='badge']")
    private WebElement plusBadge;

    @FindBy(css = "[data-testid='base-card-link']")
    private WebElement image;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage open() {
        open(SEARCH_PAGE_PATH);
        return this;
    }

    public SearchPage acceptCookies() {
        click(acceptAllCookiesBtn);
        switchToFrame(iframeSocialSearch);
        return this;
    }

    public SearchPage clickOnFilterButton() {
        click(filterBtn);
        return this;
    }

    public void clickOnFirstImage() {
        click(image);
    }

    public SearchPage checkPersonalFilter() {
        click(personalFilterCheckBox);
        return this;
    }

    public boolean isFilterToolbarVisible() {
        return searchFilterToolbar.isDisplayed();
    }

    public boolean isPlusBadgeVisible() {
        return wait.waitUntilElementToBeVisible(plusBadge).isDisplayed();
    }

    public boolean isPlusBadgeInvisible() {
        return wait.waitUntilElementToBeInvisible(plusBadge);
    }
}
package com.picsart.ui.pages;

import com.picsart.ui.utils.ConfigManager;
import com.picsart.ui.utils.WaitUtils;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage<T extends BasePage<T>> {
    public static final ConfigManager config = ConfigFactory.create(ConfigManager.class);
    protected String baseUrl = config.baseUrl();
    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    protected BasePage<T> open(final String url) {
        driver.get(url);
        wait.waitForPageLoadComplete();
        return this;
    }

    protected void switchToFrame(WebElement element) {
        wait.waitForPageLoadComplete();
        driver.switchTo().frame(element);
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void click(WebElement element) {
        wait.waitForPageLoadComplete();
        wait.waitUntilElementToBeVisible(element);
        wait.waitForElementClickable(element);
        scrollToElement(element);
        element.click();
    }

    protected boolean isVisible(WebElement element) {
        wait.waitForPageLoadComplete();
        return wait.waitUntilElementToBeVisible(element).isDisplayed();
    }

    protected boolean isInvisible(WebElement element) {
        wait.waitForPageLoadComplete();
        return wait.waitUntilElementToBeInvisible(element);
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    }

    protected void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }


    protected String getImageLink(WebElement element) {
        isVisible(element);
        return element.getDomAttribute("href");
    }

    @Step
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step
    public void goBack() {
        driver.navigate().back();
    }
}

package com.picsart.ui.pages;

import com.picsart.ui.utils.ConfigManager;
import com.picsart.ui.utils.WaitUtils;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
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
        wait.waitForElementClickable(element).click();
    }

    protected boolean isVisible(WebElement element) {
        wait.waitForPageLoadComplete();
        return wait.waitUntilElementToBeVisible(element).isDisplayed();
    }

    protected boolean isInvisible(WebElement element) {
        wait.waitForPageLoadComplete();
        return wait.waitUntilElementToBeInvisible(element);
    }

    @Step
    public void goBack() {
        driver.navigate().back();
    }
}

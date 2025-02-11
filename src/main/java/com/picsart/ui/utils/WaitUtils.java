package com.picsart.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.picsart.ui.pages.BasePage.config;
import static org.openqa.selenium.support.ui.ExpectedConditions.jsReturnsValue;


public class WaitUtils {
    private final WebDriverWait longWait;
    private final WebDriverWait shortWait;
    private final NetworkUtils networkUtils;

    public WaitUtils(WebDriver driver) {
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(config.shortTimeout()));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(config.longTimeout()));
        this.networkUtils = new NetworkUtils();
    }

    public void waitForPageLoadComplete() {
        longWait.until((jsReturnsValue("return document.readyState =='complete';")));
        networkUtils.waitForResourcesToLoad(config.longTimeout());
    }

    public WebElement waitForElementClickable(WebElement element) {
        return longWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilElementToBeVisible(WebElement element) {
        return longWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitUntilElementToBeInvisible(WebElement element) {
        return shortWait.until(ExpectedConditions.invisibilityOf(element));
    }
}


package com.picsart.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImagePage extends BasePage<ImagePage> {

    @FindBy(css = "button[data-testid='likeComponent']")
    private WebElement likeBtn;

    @FindBy(css = "button[class*='info-block-editButton']")
    private WebElement editThisImageBtn;

    @FindBy(css = "button[class*='smart-drop-down-actionButton']")
    private WebElement saveBtn;

    public ImagePage(WebDriver driver) {
        super(driver);
    }
    @Step
    public boolean isImageLikedButtonVisible() {
        return wait.waitUntilElementToBeVisible(likeBtn).isDisplayed();
    }
    @Step
    public boolean isEditThisImageButtonVisible() {
        return wait.waitUntilElementToBeVisible(editThisImageBtn).isDisplayed();
    }
    @Step
    public boolean isSaveButtonVisible() {
        return wait.waitUntilElementToBeVisible(saveBtn).isDisplayed();
    }
    @Step
    public ImagePage clickOnLikeButton() {
        click(likeBtn);
        return this;
    }
}
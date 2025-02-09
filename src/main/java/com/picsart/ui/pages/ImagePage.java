package com.picsart.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImagePage extends BasePage<ImagePage> {

    @FindBy(css = "button[data-testid='likeComponent']")
    private WebElement likeBtn;

    @FindBy(css = "button.info-block-editButton-0-2-153")
    private WebElement editThisImageBtn;

    @FindBy(css = "button.smart-drop-down-actionButton-0-2-197")
    private WebElement saveBtn;

    public ImagePage(WebDriver driver) {
        super(driver);
    }

    public boolean isImageLikedButtonVisible() {
        return wait.waitUntilElementToBeVisible(likeBtn).isDisplayed();
    }

    public boolean isEditThisImageButtonVisible() {
        return wait.waitUntilElementToBeVisible(editThisImageBtn).isDisplayed();
    }

    public boolean isSaveButtonVisible() {
        return wait.waitUntilElementToBeVisible(saveBtn).isDisplayed();
    }

    public ImagePage clickOnLikeButton() {
        click(likeBtn);
        return this;
    }
}
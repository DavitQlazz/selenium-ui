package com.picsart.ui.components;

import com.picsart.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPopup extends BasePage<SignInPopup> {

    @FindBy(css = "div[data-testid='registration-modal-container']")
    private WebElement signInPopup;

    @FindBy(css = "div[data-pulse-name='modal-close'] svg")
    private WebElement signInPopupCloseBtn;

    public SignInPopup(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInPopupVisible() {
        return wait.waitUntilElementToBeVisible(signInPopup).isDisplayed();
    }

    public void closeSignInPopup() {
        click(signInPopupCloseBtn);
    }
}

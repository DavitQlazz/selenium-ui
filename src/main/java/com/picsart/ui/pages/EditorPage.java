package com.picsart.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditorPage extends BasePage<EditorPage> {

    @FindBy(css = "[data-testid*='editor-toolbar']")
    private WebElement editorToolbar;

    @FindBy(css = "canvas")
    private WebElement canvas;

    public EditorPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean isEditorToolbarVisible() {
        return isVisible(editorToolbar);
    }

    @Step
    public boolean isCanvasVisible() {
        return isVisible(canvas);
    }
}

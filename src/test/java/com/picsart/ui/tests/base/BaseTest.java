package com.picsart.ui.tests.base;

import com.picsart.ui.base.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("resolution")
    @BeforeMethod
    public void setup(@Optional("1024x768") String resolution) {
        driver = DriverManager.getDriver();
        setResolution(resolution);
    }

    private void setResolution(String resolution) {
        String[] dimensions = resolution.split("x");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);
        driver.manage().window().setSize(new Dimension(width, height));
    }

    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}

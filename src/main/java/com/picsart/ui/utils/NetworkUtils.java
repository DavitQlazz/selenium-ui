package com.picsart.ui.utils;

import com.picsart.ui.base.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class NetworkUtils {
    private static final Duration IDLE_TIME = Duration.ofSeconds(1);
    private final WebDriver driver;

    public NetworkUtils() {
        driver = DriverManager.getDriver();
    }

    /**
     * Waits until the resources are loaded.
     */
    public void waitForResourcesToLoad(int timeout) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        AtomicReference<Long> initialRequestCount = new AtomicReference<>(0L);
        new WebDriverWait(driver, Duration.ofSeconds(timeout), IDLE_TIME).until(webDriver -> {
            try {
                String script = """
                        return window.performance.getEntriesByType('resource')
                            .filter(e => e.initiatorType !== 'xmlhttprequest')
                            .length;""";
                Long requestCount = (Long) js.executeScript(script);
                if (Objects.equals(requestCount, initialRequestCount.get())) {
                    return true;
                }
                initialRequestCount.set(requestCount);
                return false;
            } catch (Exception e) {
                return false;
            }
        });
    }
}

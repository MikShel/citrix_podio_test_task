/**
 * *****************************************************************************
 * Copyright (c) 2012. Strevus, Inc. All rights reserved
 * ****************************************************************************
 */
package support.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.selenium.drivers.FirefoxDriver;
import support.selenium.drivers.PhantomJSDriver;

import java.io.File;
import java.io.IOException;


public class Browser {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Browser.class);
    private static final int TIMEOUT = 10;
    private static final int ATTEMPT_DELAY = 300;
    public static final String ROOT_URL = "/";
    private static Browser INSTANCE;
    private String baseUrl;
    private static WebDriver driver;
    private static Wait wait;
    private String winHandleBefore;

    private Browser(String baseUrl) {
        this.baseUrl = baseUrl;
        String browser = System.getProperty("browser");
        switch (browser){
            case "ff":
                driver = FirefoxDriver.get();
                break;
            case "pjs":
                driver = PhantomJSDriver.get();
                break;
        }
        wait = new WebDriverWait(driver, TIMEOUT, ATTEMPT_DELAY);
        driver.get(baseUrl);
    }

    public static void start(String baseUrl) {
        if (INSTANCE != null) {
            throw new RuntimeException("Browser has already been started");
        }
        INSTANCE = new Browser(baseUrl);
    }

    public static Browser get() {
        if (INSTANCE == null) {
            throw new RuntimeException("Browser has not been started");
        }
        return INSTANCE;
    }

    public static Wait getWait() {
        return wait;
    }

    public static void stop() {
        if (INSTANCE != null) {
            INSTANCE.driver.quit();
            INSTANCE = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void visitHome() {
        visitPage(ROOT_URL);
    }

    public void visitPage(String page) {
        INSTANCE.driver.get(baseUrl + page);
    }

    public void visitURL(String page) {
        INSTANCE.driver.get(page);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl().substring(this.baseUrl.length());
    }

    public String getFullUrl() {
        return this.driver.getCurrentUrl();
    }

    public String pageContent() {
        return driver.getPageSource();
    }

    public void dumpState(String saveScreenShotTo) {
    //    LOGGER.warn("Current URL: " + driver.getCurrentUrl());
    //    LOGGER.warn("Page content:\n" + pageContent());
        takeScreenShot(saveScreenShotTo);
    }

    private void takeScreenShot(String saveScreenShotTo) {
     //   LOGGER.warn("Screenshot of the failed test saved to " + saveScreenShotTo);
        try {
            FileUtils.copyFile(getScreenshot(), new File(saveScreenShotTo));
        } catch (IOException e) {
            throw new RuntimeException("Can not save screenshot", e);
        }
    }

    private File getScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

}
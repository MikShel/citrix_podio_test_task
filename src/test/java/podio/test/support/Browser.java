/**
 * *****************************************************************************
 * Copyright (c) 2012. Strevus, Inc. All rights reserved
 * ****************************************************************************
 */
package podio.test.support;

import org.openqa.selenium.WebDriver;
import podio.test.support.drivers.ChromeDriver;
import podio.test.support.drivers.FirefoxDriver;
import podio.test.support.drivers.PhantomJSDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;


public class Browser {

    private static Browser INSTANCE;
    private static WebDriver driver;

    public Browser() {
        String browser = System.getProperty("browser");
        String url = System.getProperty("url");
        switch (browser) {
            case "ff":
                driver = FirefoxDriver.get();
                break;
            case "pjs":
                driver = PhantomJSDriver.get();
                break;
            case "chr":
                driver = ChromeDriver.get();
                break;
        }
        driver.get(url);
    }

    public static void start() {
        INSTANCE = new Browser();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void checkUrl(String url){
        assertThat(driver.getCurrentUrl(), containsString(url));
        assertThat(driver.getCurrentUrl(), endsWith(url));
    }


}
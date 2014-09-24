/*******************************************************************************
 * Copyright (c) 2012. Strevus, Inc.  All rights reserved
 ******************************************************************************/

package podio.test.support.drivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class FirefoxDriver {

    public static WebDriver get() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);

        WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver(capabilities);
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

}

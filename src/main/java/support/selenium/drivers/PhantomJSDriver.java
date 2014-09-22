/*******************************************************************************
 * Copyright (c) 2012. Strevus, Inc.  All rights reserved
 ******************************************************************************/

package support.selenium.drivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class PhantomJSDriver {

    public static WebDriver get() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        /*capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Settings.getPhantomJSLocation()
        );*/

        org.openqa.selenium.phantomjs.PhantomJSDriver driver = new org.openqa.selenium.phantomjs.PhantomJSDriver(capabilities);
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

}

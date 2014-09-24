/*******************************************************************************
 * Copyright (c) 2012. Strevus, Inc.  All rights reserved
 ******************************************************************************/

package podio.test.support.drivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;


public class PhantomJSDriver {

    private static PhantomJSDriverService service;

    public static WebDriver get(){
        service = new PhantomJSDriverService.Builder().
                usingPhantomJSExecutable(new File("drivers/phantomjs"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            System.err.println( "PhantomJs Service can't be started " + e.getMessage() );
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);

        WebDriver driver = new org.openqa.selenium.phantomjs.PhantomJSDriver(service, capabilities);
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

    public static void stopService(){
        service.stop();
    }

}

package podio.test.support.drivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by msheliah.
 */
public class ChromeDriver {

    private static ChromeDriverService service;


    public static WebDriver get(){
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("drivers/chromedriver"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            System.err.println( "Chrome Service can't be started " + e.getMessage() );
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(service, capabilities);
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

    public static void stopService(){
        service.stop();
    }
}

package podio.test.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import podio.test.support.Browser;
import podio.test.support.drivers.ChromeDriver;
import podio.test.support.drivers.PhantomJSDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by msheliah.
 */
public class Hooks {

    Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario){
        this.scenario = scenario;
        Browser.start();
    }

    @After
    public void tearDown(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                File screenshot = ((TakesScreenshot) Browser.getDriver()).
                        getScreenshotAs(OutputType.FILE);
                String path = "./target/screenshots/" + screenshot.getName();
                FileUtils.copyFile(screenshot, new File(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Browser.getDriver().quit();
            String browser = System.getProperty("browser");
            switch (browser) {
                case "ff":
                    break;
                case "pjs":
                    PhantomJSDriver.stopService();
                    break;
                case "ghm":
                    ChromeDriver.stopService();
                    break;
            }
        }
    }


}

package podio.test.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import podio.test.support.Browser;
import podio.test.support.drivers.ChromeDriver;
import podio.test.support.drivers.PhantomJSDriver;


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
                final byte[] screenshot = ((TakesScreenshot) Browser.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
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

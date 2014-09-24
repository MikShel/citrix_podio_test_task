package podio.test.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import podio.test.support.Browser;


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
                System.err.println("Failed scenario");
                final byte[] screenshot = ((TakesScreenshot) Browser.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } finally {
            Browser.getDriver().quit();
        }
    }


}

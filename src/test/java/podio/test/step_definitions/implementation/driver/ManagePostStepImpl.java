package podio.test.step_definitions.implementation.driver;

import org.openqa.selenium.WebDriver;
import podio.pages.HomePage;
import podio.pages.selenium.HomePageImpl;

/**
 * Created by msheliah.
 */
public class ManagePostStepImpl {

    WebDriver driver;

    private HomePage homePage;

    public ManagePostStepImpl(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePageImpl(driver);
    }


    public void createPost(String attachment, String space, String text) {
        homePage.createPost(attachment, space, text);
    }

    public void checkThatPostAppear(String attach) {
        homePage.checkThatPostAppear(attach);
    }
}

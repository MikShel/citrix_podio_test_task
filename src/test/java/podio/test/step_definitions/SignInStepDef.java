package podio.test.step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import podio.test.step_definitions.implementation.driver.SignInStepsImpl;
import podio.test.support.Browser;


public class SignInStepDef{


    WebDriver driver = Browser.getDriver();
    SignInStepsImpl signInSteps;

    @Given("^I try to login with \"([^\"]*)\" credentials$")
    public void I_try_to_login_with_credentials(String validity) {
        signInSteps = new SignInStepsImpl(driver);
        signInSteps.signIn(validity);
    }

    @Then("^I should see that I logged in \"([^\"]*)\"$")
    public void I_should_see_that_I_logged_in(String success) throws Throwable {
        signInSteps.checkSuccessLogin(success);
    }
}

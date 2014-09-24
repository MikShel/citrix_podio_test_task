package podio.test.step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import podio.test.step_definitions.implementation.driver.SignInStepsImpl;


public class SignInStepDef extends BaseStep {

    SignInStepsImpl signInSteps = new SignInStepsImpl(driver);

    @Given("^I try to login with \"([^\"]*)\" credentials$")
    public void I_try_to_login_with_credentials(String validity) {
        signInSteps.signIn(validity);
    }

    @Then("^I should see that I logged in \"([^\"]*)\"$")
    public void I_should_see_that_I_logged_in(String success) {
        signInSteps.checkSuccessLogin(success);
    }

    @Given("^I work with the system$")
    public void I_work_with_the_system() {
        I_try_to_login_with_credentials("valid");
        I_should_see_that_I_logged_in("successfully");
    }

}

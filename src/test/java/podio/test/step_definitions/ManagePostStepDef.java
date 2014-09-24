package podio.test.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import podio.test.step_definitions.implementation.driver.ManagePostStepImpl;

/**
 * Created by msheliah.
 */
public class ManagePostStepDef extends BaseStep {

    ManagePostStepImpl managePostStep = new ManagePostStepImpl(driver);

    private final String POST_TEXT = "New post on " + System.currentTimeMillis() + " was created";

    @Given("^I create status post with \"([^\"]*)\" attachment for \"([^\"]*)\"$")
    public void I_create_status_post_with_attachment(String attachment, String space) throws Throwable {
        managePostStep.createPost(attachment, space, POST_TEXT);
    }

    @Then("^The post should appear in stream with \"([^\"]*)\"$")
    public void The_post_should_appear_in_stream(String attach) throws Throwable {
        managePostStep.checkThatPostAppear(attach);
    }

}

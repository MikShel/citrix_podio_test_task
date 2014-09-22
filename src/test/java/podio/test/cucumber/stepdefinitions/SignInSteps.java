package podio.test.cucumber.stepdefinitions;


import cucumber.api.java.en.Then;
import podio.steps.SignInStepsReal;

public class SignInSteps {


    SignInStepsReal signInSteps;


    @Then("^I sign in as \\\"([^\\\"]*)\\\"$")
    public  void i_see_todays_weather (String town){
        signInSteps = new SignInStepsReal();
        signInSteps.searchTown(town);
    }

}

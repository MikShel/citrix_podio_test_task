package podio.test.cucumber.stepdefinitions;


import cucumber.api.java.en.Then;
import podio.steps.SignInStepsReal;
import support.selenium.Browser;

public class SignInSteps {


    SignInStepsReal signInSteps;


    @Then("^I sign in as \"([^\"]*)\"$")
    public  void i_sign_in_as(String name){
        Browser.get();
        System.out.println("!!!!!!!!!!");
        signInSteps = new SignInStepsReal();
        signInSteps.signIn(name);
    }

}

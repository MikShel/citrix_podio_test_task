package podio.test.step_definitions.implementation.driver;

import org.openqa.selenium.WebDriver;
import podio.pages.HomePage;
import podio.pages.MainPage;
import podio.pages.SignInPage;
import podio.pages.selenium.HomePageImpl;
import podio.pages.selenium.MainPageImpl;
import podio.pages.selenium.SignInPageImpl;
import podio.test.support.Utils;

/**
 * Created by msheliah.
 */
public class SignInStepsImpl {
    WebDriver driver;

    private SignInPage signInPage;
    private MainPage mainPage;
    private HomePage homePage;

    public SignInStepsImpl(WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPageImpl(driver);
        mainPage = new MainPageImpl(driver);
        homePage = new HomePageImpl(driver);
    }

    public void signIn (String validity){
        mainPage.moveToSignIn();
        switch (validity){
            case "valid" :
                signInPage.fillCredentials(Utils.getCredentials(true));
                break;
            case "invalid" :
                signInPage.fillCredentials(Utils.getCredentials(false));
                break;
        }
        signInPage.submitForm();

    }

    public void checkSuccessLogin(String success) {
        switch (success){
            case "successfully" :
                homePage.checkSuccessfulLogin();
                break;
            case "unsuccessfully" :
                signInPage.checkFailLogin();
                break;
        }
    }
}

package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import podio.test.support.CommonSteps;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

/**
 * Created by msheliah.
 */
@Name("Login Form block")
@Block(@FindBy(css = "div.with-foot"))
public class LoginForm extends HtmlElement{

    @Name("Email input")
    @FindBy(css = "input.email")
    private TextInput emailInput;

    @Name("Password input")
    @FindBy(css = "input#password")
    private TextInput passInput;

    @Name("Forgot password link")
    @FindBy(css = "div.forgot-password > a")
    private Link forgotPassLink;

    @Name("Enter button")
    @FindBy(css = "button[type=\"submit\"]")
    public Button enterButton;

    @Name("Warning message")
    @FindBy(css = "ul.warning")
    private TextBlock warningMessage;

    @Name("Warning Forgot Pass Link")
    @FindBy(css = "a[href^=\"/user/recover\"]")
    private TextBlock warningForgotPassLink;

    CommonSteps commonSteps = new CommonSteps();


    public void fillCredentials(String email, String pass) {
        commonSteps.inputText(emailInput, email);
        commonSteps.inputText(passInput, pass);
        commonSteps.clickOn(enterButton);
    }

    public void submitCredentials(){
        commonSteps.clickOn(enterButton);
    }


    public void checkWarning() {
        commonSteps.shouldSeeElement(warningMessage);
        commonSteps.shouldSeeElement(warningForgotPassLink);
    }
}

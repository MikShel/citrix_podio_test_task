package podio.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import podio.pages.SignInPage;
import podio.pages.selenium.elements.LoginForm;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.Map;

/**
 * Created by msheliah.
 */
public class SignInPageImpl extends CommonPage implements SignInPage {

    private final String URL = "/login";

    @Name("Enter link in the Header")
    @FindBy(css = "div.language_select")
    private Select languageChanger;

    private LoginForm loginForm;

    public SignInPageImpl(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
    }

    @Override
    public void fillCredentials(Map<String, String> credentials) {
        checkPage(URL, loginForm);
        loginForm.fillCredentials(credentials.get("login"), credentials.get("pass"));
    }

    @Override
    public void submitCredentials() {
        loginForm.submitCredentials();
    }

    @Override
    public void checkFailLogin() {
        checkPage(URL, loginForm);
        loginForm.checkWarning();
    }
}

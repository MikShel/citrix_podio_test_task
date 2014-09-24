package podio.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import podio.pages.MainPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class MainPageImpl extends CommonPage  implements MainPage {

    @Name("Enter link in the Header")
    @FindBy(css = "span > a[data-tracking^=\"Login\"]")
    private Link enterLink;

    @Name("Sign-up form on the main page")
    @FindBy(css = "form.signup-form")
    private Form signUpForm;

    public MainPageImpl(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
    }

    public MainPageImpl() {
    }


    @Override
    public void moveToSignIn() {
        checkPage("", signUpForm);
        commonSteps.clickOn(enterLink);
        commonSteps.shouldNotSeeElement(enterLink);
    }
}

package podio.pages.selenium;

import org.openqa.selenium.WebDriver;
import podio.pages.HomePage;
import podio.pages.selenium.elements.GlobalStream;
import podio.pages.selenium.elements.NavigationBox;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by msheliah.
 */
public class HomePageImpl extends CommonPage implements HomePage{

    private final String URL = "/home";
    private NavigationBox navBox;
    private GlobalStream globalStream;

    public HomePageImpl(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
    }

    @Override
    public void checkSuccessfulLogin() {
        checkPage(URL, globalStream);
    }

}

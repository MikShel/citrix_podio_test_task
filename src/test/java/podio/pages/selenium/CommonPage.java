package podio.pages.selenium;

import org.openqa.selenium.internal.WrapsElement;
import podio.test.support.Browser;
import podio.test.support.CommonSteps;

/**
 * Created by msheliah.
 */
public class CommonPage {

    CommonSteps commonSteps = new CommonSteps();

    public void checkPage(String url, WrapsElement element){
        commonSteps.shouldSeeElement(element);
        Browser.checkUrl(url);
    }

}

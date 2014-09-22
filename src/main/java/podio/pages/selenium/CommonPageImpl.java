package podio.pages.selenium;

import org.openqa.selenium.WebDriver;
import podio.pages.CommonPage;
import support.selenium.Browser;

import static org.junit.Assert.*;


public class CommonPageImpl implements CommonPage {

    WebDriver  driver;

    public CommonPageImpl() {
        this.driver = Browser.getDriver();

    }

    @Override
    public void navigate(String url) {
        driver.get(url);
        assertTrue(driver.getCurrentUrl().contains(url));
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

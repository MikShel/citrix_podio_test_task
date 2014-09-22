package podio.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import podio.pages.HomePage;
import podio.pages.selenium.elements.Search;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import support.selenium.Browser;

public class HomePageImpl implements HomePage {
    @FindBy(css = "div.b-head-search")
    private Search searchElement;

    @FindBy(css = "span.b-navigation-city__city")
    private TextBlock townName;


    @FindBy(css = "table.b-forecast__layout")
    private Table futureWeatherTable;

    WebDriver driver;

    public HomePageImpl() {
        this.driver = Browser.getDriver();
    }

    @Override
    public void searchTown(String town) {
        System.out.println("Search town step go");

    }

}

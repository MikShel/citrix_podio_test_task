package podio.steps.selenium;

import podio.pages.CommonPage;
import podio.pages.HomePage;
import podio.pages.selenium.CommonPageImpl;
import podio.pages.selenium.HomePageImpl;
import support.selenium.StepBase;

public class SignInStepsImpl extends StepBase{

    CommonPage commonPage;
    HomePage homePage;


    public SignInStepsImpl() {
        commonPage = new CommonPageImpl();
        homePage = new HomePageImpl();

    }

    public void searchTown(String town) {
        homePage.searchTown(town);
    }

}

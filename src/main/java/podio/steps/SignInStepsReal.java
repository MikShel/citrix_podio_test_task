package podio.steps;

import podio.pages.CommonPage;
import podio.pages.HomePage;
import podio.pages.selenium.CommonPageImpl;
import podio.pages.selenium.HomePageImpl;
import support.selenium.StepBase;

public class SignInStepsReal extends StepBase {

    CommonPage commonPage;
    HomePage homePage;


    public SignInStepsReal() {

            commonPage = new CommonPageImpl();
            homePage = new HomePageImpl();


    }

    public void signIn(String town) {
        homePage.searchTown(town);
    }

}

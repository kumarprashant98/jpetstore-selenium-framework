package jpetstore;

import base.BaseTest;
import datafactory.UserInformationData;
import dataobject.UserInformation;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.products.ProductsPO;
import utilities.Constants;


public class ProductTest extends BaseTest {
    @Test
    public void verifyThatAllProductLinksAreClickable() throws InterruptedException {
        ProductsPO product = new ProductsPO(driver);
        HomePagePO homePage = new HomePagePO(driver);
        LoginPO login = new LoginPO(driver);
        UserInformation userData = new UserInformationData().loginData();

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step 2 : Click on 'SignIn' link");
        homePage.clickOnSignInLink();

        Reporter.log("Step 3 : Enter registered 'UserId' and 'Password' and click on 'SignIn' button.");
        login.enterLoginData(userData);

        Reporter.log("Step 5 : Click on 'Dog' from 'Animal Category' and verify that user is navigate to products category page.");
        homePage.clickOnProductCategory();
        Assert.assertTrue(product.isHeaderTextPresent(), "Header text is not displayed");

        Reporter.log("Step 5 : Verify that the all links of 'Product ID' are clickable.");
        Assert.assertTrue(product.isProductsIdLinksClickable(), "Products id links are not clickable.");
    }
}

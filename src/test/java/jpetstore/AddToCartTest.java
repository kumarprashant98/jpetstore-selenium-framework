package jpetstore;

import base.BaseTest;
import datafactory.UserInformationData;
import dataobject.UserInformation;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.addtocart.AddToCartPO;
import pageobjects.products.ProductsPO;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.products.productdetails.ItemDetailPO;
import pageobjects.products.productdetails.ItemPO;
import pageobjects.signup.SignUpPO;
import utilities.Constants;
import utilities.SeleniumHelper;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyThatProductIsSuccessfullyAddedToTheCart() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        ProductsPO product = new ProductsPO(driver);
        HomePagePO homePage = new HomePagePO(driver);
        ItemPO item = new ItemPO(driver);
        AddToCartPO addtocart = new AddToCartPO(driver);
        ItemDetailPO itemdetail = new ItemDetailPO(driver);
        UserInformation userData = new UserInformationData().loginData();

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step 2 : Click on 'SignIn' link");
        homePage.clickOnSignInLink();

        Reporter.log("Step 3 : Enter registered 'UserId' and 'Password' and click on 'SignIn' button.");
        login.enterLoginData(userData);

        Reporter.log("Step 4 : verify that 'Welcome' text is present.");
        String userName = "QA";
        Assert.assertEquals(homePage.getWelcomeText(), "Welcome " + userName + "!", "Welcome Text is not present.");

        Reporter.log("Step 5 : Click on 'Dog' from 'Animal Category' and verify that user is navigate to products category page.");
        homePage.clickOnProductCategory();
        String productID = product.getProductId();//iska use next kaha pe hai mention it in comment
        Assert.assertTrue(product.isHeaderTextPresent(), "Header text is not displayed");

        Reporter.log("Step 6 : Click on 'Product ID' and verify that user is navigated to selected item page.");
        product.clickOnProductId();
        String productHeaderName = item.getItemPageHeader();
        Assert.assertEquals(product.getProductName(), productHeaderName, "Product name and product header name are not matched.");

        Reporter.log("Step 7 : Click on 'Item ID' and verify that user is navigated to selected item description page.");
        String itemName = item.getItemName();
        item.clickOnItemId();
        Assert.assertEquals(itemdetail.getItemDescriptionName(), itemName, "Item name and item description name are not matched.");

        Reporter.log("Step 8 : Click on 'Add To Cart' button and verify that user is navigate to 'Add To Cart' page.");
        itemdetail.clickOnAddToCartButton();
        Assert.assertTrue(addtocart.isHeaderTextPresent(), "Header text is not present.");

        Reporter.log("Step 9 : Verify that product is added to cart successfully.");
        Assert.assertEquals(addtocart.getProductID(), productID, "Product is not added to cart.");

    }

    @Test
    public void verifyThatCountIsIncreasedAfterAddingProductToCart() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        ProductsPO product = new ProductsPO(driver);
        HomePagePO homePage = new HomePagePO(driver);
        ItemPO item = new ItemPO(driver);
        AddToCartPO addtocart = new AddToCartPO(driver);
        ItemDetailPO itemdetail = new ItemDetailPO(driver);
        UserInformation userData = new UserInformationData().loginData();

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step 2 : Click on 'SignIn' link");
        homePage.clickOnSignInLink();

        Reporter.log("Step 3 : Enter registered 'UserId' and 'Password' and click on 'SignIn' button.");
        login.enterLoginData(userData);

        Reporter.log("Step 4 : verify that 'Welcome' text is present.");
        String userName = "QA";
        Assert.assertEquals(homePage.getWelcomeText(), "Welcome " + userName + "!", "Welcome Text is not present.");

        Reporter.log("Step 5 : Click on 'Dog' from 'Animal Category' and verify that user is navigated to products category page.");
        homePage.clickOnProductCategory();
        Assert.assertTrue(product.isHeaderTextPresent(), "Header text is not displayed");

        Reporter.log("Step 6 :Click on 'Product ID' and verify that user is navigated to selected item page.");
        product.clickOnProductId();
        String productHeaderName = item.getItemPageHeader();
        Assert.assertEquals(product.getProductName(), productHeaderName, "Product name and product header name are not matched.");

        Reporter.log("Step 7 :Click on 'Item ID' and verify that user is navigated to selected item description page.");
        String itemName = item.getItemName();
        item.clickOnItemId();
        Assert.assertEquals(itemdetail.getItemDescriptionName(), itemName, "Item name and item description name are not matched.");

        Reporter.log("Step 8 : Click on 'Add To Cart' button and verify that user is navigated to 'Add To Cart' page.");
        itemdetail.clickOnAddToCartButton();
        Assert.assertTrue(addtocart.isHeaderTextPresent(), "Header text is not present.");

        Reporter.log("Step 9 : Navigate back to page and click on 'Add To Cart' button.");
        driver.navigate().back();
        itemdetail.clickOnAddToCartButton();

        Reporter.log("Step 10 : Verify that quantity is increased or not.");
        int num = 2;
        Assert.assertEquals(addtocart.getQuantity(), num, "Quantity is not increased.");
    }

}

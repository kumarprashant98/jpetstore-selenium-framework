package jpetstore;

import base.BaseTest;
import datafactory.UserInformationData;
import dataobject.UserInformation;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.addtocart.AddToCartPO;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.payment.PaymentPO;
import pageobjects.placeorder.PlaceOrderPO;
import pageobjects.products.ProductsPO;
import pageobjects.products.productdetails.ItemDetailPO;
import pageobjects.products.productdetails.ItemPO;
import utilities.Constants;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void verifyThatOrderIsPlacedSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        ProductsPO product = new ProductsPO(driver);
        HomePagePO homePage = new HomePagePO(driver);
        ItemPO item = new ItemPO(driver);
        AddToCartPO addtocart = new AddToCartPO(driver);
        ItemDetailPO itemdetail = new ItemDetailPO(driver);
        PaymentPO payment = new PaymentPO(driver);
        PlaceOrderPO placeOrder = new PlaceOrderPO(driver);
        UserInformation userData = new UserInformationData().loginData();
        UserInformation paymentData = new UserInformationData().paymentData();

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step 2 : Click on 'SignIn' link.");
        homePage.clickOnSignInLink();

        Reporter.log("Step 3 : Enter registered 'UserId' and 'Password' and click on 'SignIn' button.");
        login.enterLoginData(userData);

        Reporter.log("Step 4 : verify that 'Welcome' text is present.");
        String userName = "QA";
        Assert.assertEquals(homePage.getWelcomeText(), "Welcome " + userName + "!", "Welcome Text is not present.");

        Reporter.log("Step 5 : Click on 'Dog' from 'Animal Category' and verify that user is navigate to products category page.");
        homePage.clickOnProductCategory();
        String productID = product.getProductId();    //used below in product added to cart assertion 'Step 9'.
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

        Reporter.log("Step 10 : Click on checkout link and verify that user is navigate to 'Payment Details' page.");
        addtocart.clickOnCheckOutLink();
        Assert.assertTrue(payment.isHeaderTextPresent(), "Header text is not present");

        Reporter.log("Step 11 : Enter payment details and click on 'Continue' button.");
        payment.enterPaymentDetails(paymentData);
        Thread.sleep(2000);
        payment.clickOnContinueButton();

        Reporter.log("Step 12 : Verify That user is navigate to 'Confirmation' page and click on 'Confirm' button.");
        Assert.assertTrue(placeOrder.isConfirmationTextPresent(), "Confirmation text is not displayed.");
        placeOrder.clickOnConfirmButton();

        Reporter.log("Step 13 : Verify that Order is placed successfully");
        Assert.assertTrue(placeOrder.isOrderSubmittedTextPresent(), "Order is not placed successfully.");
    }
}

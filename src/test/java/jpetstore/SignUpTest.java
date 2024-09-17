package jpetstore;

import base.BaseTest;
import datafactory.UserInformationData;
import dataobject.UserInformation;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.signup.SignUpPO;
import utilities.Constants;


public class SignUpTest extends BaseTest {

    /* Test1: Verify that user can create an account successfully */

    @Test
    public void verifyThatUserCanCreateAnAccountSuccessfully() throws InterruptedException {
        SignUpPO signup = new SignUpPO(driver);
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        UserInformation userData = new UserInformationData().UserInformation();

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step 2 : Click on 'SignIn' link");
        homepage.clickOnSignInLink();

        Reporter.log("Step 3 : Verify that user is navigated to the 'SignIn' page");
        String signInPageHeaderText = "Please enter your username and password.";
        Assert.assertEquals(login.getHeaderText(), signInPageHeaderText, "Header text is not matched.");

        Reporter.log("Step 4 : Click on 'RegisterNow' link");
        signup.clickOnRegisterNowLink();

        Reporter.log("Step 5 : Verify that user is navigated to the 'Registration' page");
        String signUpPageHeaderText = "User Information";
        Assert.assertEquals(signup.getHeaderText(), signUpPageHeaderText, "Header text is not matched.");

        Reporter.log("Step 6 : Enter valid data in all the fields and click on 'Save Account Information' button.");
        signup.enterUserInformation(userData);

        Reporter.log("Step 7 : Click on 'SignIn' link.");
        homepage.clickOnSignInLink();

        Reporter.log("Step 8 : Enter registered 'UserId' and 'Password' and click on 'SignIn' button.");
        login.enterLoginData(userData);

        Reporter.log("Step 9 : verify that 'Welcome' text is present.");
        String userName = userData.getFirstName();
        Assert.assertEquals(homepage.getWelcomeText(), "Welcome " + userName + "!", "Welcome Text is not present.");
    }

    @Test
    public void verifyThatValidationMessageIsDisplayedWhenUserEnterInvalidDataInTheAllFields() throws InterruptedException {
        SignUpPO signup = new SignUpPO(driver);
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        UserInformation userData = new UserInformationData().InvalidUserData();

        Reporter.log("Step1: Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step2: Click on 'SignIn' link");
        homepage.clickOnSignInLink();

        Reporter.log("Step 3 : Verify that user is navigated to the 'SignIn' page");
        String signInPageHeaderText = "Please enter your username and password.";
        Assert.assertEquals(login.getHeaderText(), signInPageHeaderText, "Header text does not matched.");

        Reporter.log("Step 4:  Click on 'RegisterNow' link");
        signup.clickOnRegisterNowLink();

        Reporter.log("Step 5 : Verify that user is navigated to the 'SignIn' page");
        String signUpPageHeaderText = "User Information";
        Assert.assertEquals(signup.getHeaderText(), signUpPageHeaderText, "Header text does not matched.");

        Reporter.log("Step 6 : Enter invalid data in all the fields and click on 'Save Account Information' button.");
        signup.enterUserInformation(userData);

        Reporter.log("Step 7 : Verify that error message is displayed.");
        Assert.assertTrue(signup.isErrorTextPresent(), "Error message is not displayed.");
    }

    @Test
    public void verifyThatValidationMessageIsDisplayedWhenTheValueOfNewPasswordAndRepeatPasswordAreNotSame() throws InterruptedException {
        SignUpPO signup = new SignUpPO(driver);
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        UserInformation userData = new UserInformationData().DifferentDataInPasswordAndConfirmPassword();

        Reporter.log("Step1: Navigate to URL");
        selenium.navigateToPage(Constants.User_URL);

        Reporter.log("Step2: Click on 'SignIn' link");
        homepage.clickOnSignInLink();

        Reporter.log("Step 3 : Verify that user is navigated to the 'SignIn' page");
        String signInPageHeaderText = "Please enter your username and password.";
        Assert.assertEquals(login.getHeaderText(), signInPageHeaderText, "Header text does not matched.");

        Reporter.log("Step 4 : Click on 'RegisterNow' link");
        signup.clickOnRegisterNowLink();

        Reporter.log("Step 5 : Verify that user is navigated to the 'SignIn' page");
        String signUpPageHeaderText = "User Information";
        Assert.assertEquals(signup.getHeaderText(), signUpPageHeaderText, "Header text does not matched.");

        Reporter.log("Step 6 : Enter different data in password and confirm password and click on 'Save Account Information' button.");
        signup.enterUserInformation(userData);

        Reporter.log("Step 7 : Verify that error message is displayed.");
        Assert.assertTrue(signup.isErrorTextPresent(), "Error message is not displayed.");
    }
}

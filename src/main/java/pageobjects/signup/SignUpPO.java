package pageobjects.signup;

import dataobject.UserInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class SignUpPO extends BasePO {
    public SignUpPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@id='Catalog']/form/h3")
    private WebElement headerText;
    @FindBy(xpath = "//input[starts-with(@id,'stripes')]")
    private WebElement userIdTextBox;
    @FindBy(name = "password")
    private WebElement newPasswordTextBox;
    @FindBy(name = "repeatedPassword")
    private WebElement repeatedPasswordTextBox;
    @FindBy(name = "account.firstName")
    private WebElement firstNameTextBox;
    @FindBy(name = "account.lastName")
    private WebElement lastNameTextBox;
    @FindBy(name = "account.email")
    private WebElement emailTextBox;
    @FindBy(name = "account.phone")
    private WebElement phoneTextBox;
    @FindBy(name = "account.address1")
    private WebElement address1TextBox;
    @FindBy(name = "account.address2")
    private WebElement address2TextBox;
    @FindBy(name = "account.city")
    private WebElement cityTextBox;
    @FindBy(name = "account.state")
    private WebElement stateTextBox;
    @FindBy(name = "account.zip")
    private WebElement zipCodeTextBox;
    @FindBy(name = "account.country")
    private WebElement countryTextBox;
    @FindBy(name = "account.languagePreference")
    private WebElement languageDropDown;
    @FindBy(name = "account.favouriteCategoryId")
    private WebElement categoryDropDown;
    @FindBy(name = "account.listOption")
    private WebElement myListCheckBox;
    @FindBy(name = "account.bannerOption")
    private WebElement myBannerCheckBox;
    @FindBy(name = "newAccount")
    private WebElement accountInformationButton;
    @FindBy(xpath = "//a[contains(text(),'Register Now!')]")
    private WebElement registerNowLink;

    @FindBy(xpath = "//hr[@class='line']/preceding-sibling::h1")
    private WebElement errorMessage;


    /**
     * Enter the user information
     *
     * @param userInformation test
     */
    public void enterUserInformation(UserInformation userInformation) throws InterruptedException {
        selenium.enterText(userIdTextBox, userInformation.getUserId(), true);
        selenium.enterText(newPasswordTextBox, userInformation.getNewPassword(), true);
        selenium.enterText(repeatedPasswordTextBox, userInformation.getRepeatPassword(), true);
        selenium.enterText(firstNameTextBox, userInformation.getFirstName(), true);
        selenium.enterText(lastNameTextBox, userInformation.getLastName(), true);
        selenium.enterText(emailTextBox, userInformation.getEmail(), true);
        selenium.enterText(phoneTextBox, userInformation.getPhone(), true);
        selenium.enterText(address1TextBox, userInformation.getAddress1(), true);
        selenium.enterText(address2TextBox, userInformation.getAddress2(), true);
        selenium.enterText(cityTextBox, userInformation.getCity(), true);
        selenium.enterText(stateTextBox, userInformation.getState(), true);
        selenium.enterText(zipCodeTextBox, userInformation.getZip(), true);
        selenium.enterText(countryTextBox, userInformation.getCountry(), true);
        selenium.selectDropDownValueByText(languageDropDown,userInformation.getLanguage());
        selenium.selectDropDownValueByText(categoryDropDown,userInformation.getAnimal());
        selenium.click(myListCheckBox);
        selenium.click(myBannerCheckBox);
        selenium.click(accountInformationButton);
    }

    /**
     * Click on 'RegisterNow' link
     *
     * @throws InterruptedException Exception
     */
    public void clickOnRegisterNowLink() throws InterruptedException {
        selenium.click(registerNowLink);
    }



    /**
     * Is 'Error Text' present?
     *
     * @return true or false
     */
    public boolean isErrorTextPresent() {
        return selenium.isElementPresent(errorMessage);
    }

    /**
     * Get header text
     *
     * @return header text
     */
    public String getHeaderText(){
        return selenium.getText(headerText);
    }
}

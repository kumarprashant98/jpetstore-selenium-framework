package pageobjects.login;

import dataobject.UserInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class LoginPO extends BasePO {
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//input[starts-with(@id,'stripes')]")
    private WebElement userNameTextBox;
    @FindBy(name = "password")
    private WebElement userPasswordTextBox;
    @FindBy(name = "signon")
    private WebElement signOnButton;
    @FindBy(xpath = "//div[@id='Catalog']/form/p")
    private WebElement headerText;


    /**
     * Enter registered data 'UserName' and 'Password'
     *
     * @param userInformation user information
     */
    public void enterLoginData(UserInformation userInformation) throws InterruptedException {
        selenium.clearTextBoxUsingKeys(userNameTextBox);
        selenium.clearTextBoxUsingKeys(userPasswordTextBox);
        selenium.enterText(userNameTextBox, userInformation.getUserId(), true);
        selenium.enterText(userPasswordTextBox, userInformation.getNewPassword(), true);
        selenium.click(signOnButton);
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

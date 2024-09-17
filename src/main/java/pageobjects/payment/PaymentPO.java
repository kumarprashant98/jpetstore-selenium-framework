package pageobjects.payment;

import dataobject.UserInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

import java.util.List;

public class PaymentPO extends BasePO {
    public PaymentPO (WebDriver driver){super(driver);}

    @FindBy(xpath = "//div[@id='Catalog']/form/table/tbody/tr/th")
    private WebElement headerText;
    @FindBy(name = "order.cardType")
    private WebElement cardTypeDropDown;
    @FindBy(name = "order.creditCard")
    private WebElement cardNumber;
    @FindBy(name = "order.expiryDate")
    private WebElement expiryDate;
    @FindBy(name = "newOrder")
    private WebElement continueBtn;

    /**
     * Is 'Header Text' present?
     *
     * @return true or false
     */
    public boolean isHeaderTextPresent(){
        return selenium.isElementPresent(headerText);
    }

    /**
     * Click on 'Continue' button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnContinueButton() throws InterruptedException {
        selenium.clickOn(continueBtn);
    }

    /**
     * Enter Payment Details
     *
     * @param userInformation test
     */
    public void enterPaymentDetails(UserInformation userInformation) throws InterruptedException {
        selenium.clickOn(cardTypeDropDown);

        List<WebElement> cardType = driver.findElements(By.xpath("//select[@name='order.cardType']/option"));
        for(WebElement CardType : cardType){
            if(CardType.getText().equals(userInformation.getCardType())){
                CardType.click();
                break;
            }
        }
        selenium.enterText(cardNumber,userInformation.getCardNumber(),true);
        selenium.enterText(expiryDate,userInformation.getExpiryDate(),true);
    }
}

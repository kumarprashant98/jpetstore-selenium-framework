package pageobjects.placeorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class PlaceOrderPO extends BasePO {
    public PlaceOrderPO(WebDriver driver){super(driver);}

    @FindBy(xpath = "//div[@id='Catalog']")
    private WebElement confirmation;
    @FindBy(xpath = "//a[contains(text(),'Confirm')]")
    private WebElement confirmBtn;
    @FindBy(xpath = "//ul[@class='messages']/li")
    private WebElement submit;

    /**
     * Is 'Confirmation Text' present?
     *
     * @return true or false
     */
    public boolean isConfirmationTextPresent() {
        return selenium.isElementPresent(confirmation);
    }

    /**
     * Click on 'Confirm' button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnConfirmButton() throws InterruptedException {
        selenium.clickOn(confirmBtn);
    }
    public boolean isOrderSubmittedTextPresent(){
        return selenium.isElementPresent(submit);
    }
}

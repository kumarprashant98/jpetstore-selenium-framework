package pageobjects.products.productdetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class ItemPO extends BasePO {
    public ItemPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@id='Catalog']/h2")
    private WebElement itemHeader;
    @FindBy(xpath = "//a[contains(text(),'EST-6')]")
    private WebElement itemID6;
    @FindBy(xpath = "//tbody/tr[2]/td[3]")
    private WebElement itemName;
    @FindBy(xpath = "//a[contains(text(),'EST-7')]")
    private WebElement itemID7;

    /**
     * Get header text
     *
     * @return header text
     */
    public String getItemPageHeader(){
        return selenium.getText(itemHeader);
    }

    /**
     * Click on 'Item ID' button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnItemId() throws InterruptedException {
        selenium.clickOn(itemID6);
    }

    /**
     * Click on 'Item ID' button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnItemId7() throws InterruptedException {
        selenium.clickOn(itemID7);
    }

    /**
     * Get 'Item Name' text
     *
     * @return 'Item Name' text
     */
    public String getItemName(){
        return selenium.getText(itemName);
    }

}

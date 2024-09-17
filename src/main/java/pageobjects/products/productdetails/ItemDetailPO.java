package pageobjects.products.productdetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class ItemDetailPO extends BasePO {
    public ItemDetailPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[3]")
    private WebElement itemDescriptionName;
    @FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
    private WebElement addToCartButton;

    /**
     * Get item description text
     *
     * @return item description text
     */
    public String getItemDescriptionName(){
        return selenium.getText(itemDescriptionName);
    }

    /**
     * Click on 'Add To Cart' button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnAddToCartButton() throws InterruptedException {
        selenium.clickOn(addToCartButton);
    }


}

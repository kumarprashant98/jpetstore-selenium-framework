package pageobjects.addtocart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class AddToCartPO extends BasePO {
    public AddToCartPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@id='Cart']/h2")
    private WebElement addToCartHeader;
    @FindBy(xpath = "//div[@id='Cart']/form/table/tbody/tr[2]/td[2]")
    private WebElement productID;
    @FindBy(xpath = "//td[contains(text(),'K9-BD-01')]/parent::tr/td[5]/input")
    private WebElement quantity;
    @FindBy(xpath = "//td[@colspan='8']/b")
    private WebElement remove;
    @FindBy(xpath = "//a[contains(text(),'Proceed to Checkout')]")
    private WebElement checkout;
    @FindBy(xpath = "//a[contains(text(),'EST-6')]/ancestor::tr/td[7]")
    private WebElement totalCost;
    @FindBy(xpath = "//a[contains(text(),'EST-6')]/ancestor::tr/td[6]")
    private WebElement listPriceEST6;
    @FindBy(xpath = "//a[contains(text(),'EST-7')]/ancestor::tr/td[7]")
    private WebElement listPriceEST7;
    @FindBy(xpath = "//td[contains(text(),'Sub Total')]")
    private WebElement subTotal;

    /**
     * Get header text
     *
     * @return header text
     */
    public boolean isHeaderTextPresent(){
        return selenium.isElementPresent(addToCartHeader);
    }

    /**
     * Get product id text
     *
     * @return product id text
     */
    public String getProductID(){
        return selenium.getText(productID);
    }

    /**
     * Get quantity text
     *
     * @return quantity text
     */
    public int getQuantity(){
        int Quantity = Integer.parseInt(quantity.getAttribute("value"));
        return Quantity;
    }

    /**
     * Click on 'Checkout' Link
     *
     * @throws InterruptedException Exception
     */
    public void clickOnCheckOutLink() throws InterruptedException {
        selenium.clickOn(checkout);
    }

    /**
     * Get total cost
     *
     * @return total cost
     */
    public double getTotalCost(){
        String cost = selenium.getText(totalCost);
        String cost1 = cost.replace("$","");
        double totalCost = Double.parseDouble(cost1);
        return totalCost;
    }

    /**
     * Get item price EST-6
     *
     * @return item price
     */
    public double getItemPriceEst6(){
        String price = selenium.getText(listPriceEST6);
        String price1 = price.replace("$","");
        double itemPrice = Double.parseDouble(price1);
        return itemPrice;
    }

    /**
     * Get item price EST-7
     *
     * @return item price
     */
    public double getItemPriceEst7(){
        String price = selenium.getText(listPriceEST7);
        String price1 = price.replace("$","");
        double itemPrice = Double.parseDouble(price1);
        return itemPrice;
    }

    /**
     * Get Expected total cost
     *
     * @return expected total cost
     */
    public double getExpectedTotalCost(){
        double expectedTotalPrice = getQuantity()*getItemPriceEst6();
        return expectedTotalPrice;
    }

    /**
     * Get Expected total cost
     *
     * @return expected total cost
     */
    public double getExpectedSubTotal(){
        double expectedSubTotal = getExpectedTotalCost() + getItemPriceEst7();
        return expectedSubTotal;
    }

    /**
     * Get Sub total
     *
     * @return Sub total
     */
    public double getSubTotal(){
        String cost = selenium.getText(subTotal);
        String cost1 = cost.replace("Sub Total: $","");
        double subTotal = Double.parseDouble(cost1);
        return subTotal;
    }


}

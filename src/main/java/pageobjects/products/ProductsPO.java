package pageobjects.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.base.BasePO;
import java.time.Duration;
import java.util.List;

public class ProductsPO extends BasePO {


    public ProductsPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@id='Catalog']/h2")
    private WebElement headerText;
    @FindBy(xpath = "//a[contains(text(),'K9-BD-01')]")
    private WebElement productID;
    @FindBy(xpath = "//div[@id='Catalog']/h2")
    private WebElement productName;


    /**
     * Is 'Header Text' present?
     *
     * @return true or false
     */
    public boolean isHeaderTextPresent(){
        return selenium.isElementPresent(headerText);
    }


    /**
     * Click on 'Product ID' link
     *
     * @throws InterruptedException Exception
     */
    public void clickOnProductId() throws InterruptedException {selenium.clickOn(productID);}


    /**
     * Get 'Product Name' text
     *
     * @return 'Product Name' text
     */
    public String getProductName(){return selenium.getText(productName);}


    /**
     * Get 'Product ID' text
     *
     * @return 'Product ID' text
     */
    public String getProductId(){
        return selenium.getText(productID);
    }


    /**
     * Is 'Product ID' links clickable?
     *
     * @return true or false
     */
    public boolean isProductsIdLinksClickable() throws InterruptedException {
        List<WebElement> productsId = driver.findElements(By.xpath("//div[@id='Catalog']/table/tbody/tr"));
        for(int i=2; i<=productsId.size(); i++){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            WebElement productId  =  wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//div[@id='Catalog']/table/tbody/tr["+i+"]/td/a")));
            productId.click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
        }
        return true;
    }
}

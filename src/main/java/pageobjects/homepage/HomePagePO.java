package pageobjects.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class HomePagePO extends BasePO {

    public HomePagePO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@id='SidebarContent']/a[2]")
    private WebElement productDog;
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInLink;
    @FindBy(id = "WelcomeContent")
    private WebElement welcomeText;

    /**
     * Click on 'Product Category' link
     *
     * @throws InterruptedException Exception
     */
    public void clickOnProductCategory() throws InterruptedException {
        selenium.clickOn(productDog);
    }

    /**
     * Click on 'SignIn' link
     *
     * @throws InterruptedException Exception
     */
    public void clickOnSignInLink() throws InterruptedException {
        selenium.click(signInLink);
    }

    /**
     * Get welcome text
     *
     * @return welcome text
     */
    public String getWelcomeText() {
        return selenium.getText(welcomeText);
    }
}

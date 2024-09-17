package pageobjects.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;
import utilities.SeleniumHelper;

public class BasePO {
    protected WebDriver driver;
    protected SeleniumHelper selenium;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelper(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
    }

}

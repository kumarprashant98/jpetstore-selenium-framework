package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.SeleniumHelper;


public class BaseTest {
    protected WebDriver driver;
    protected SeleniumHelper selenium;


    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }


}
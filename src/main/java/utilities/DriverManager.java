package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class DriverManager {
    private WebDriver driver;

    public WebDriver setUp(String browserName) {

        switch (browserName.toLowerCase()) {
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.setAcceptInsecureCerts(true);
                options.addPreference("dom.webnotifications.enabled", false);
                options.addPreference("dom.push.enabled", false);
                driver = new FirefoxDriver(options);
            }
            case "firefox-headless" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.addPreference("dom.push.enabled", false);
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
            }
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
            }
            case "safari" -> {
                System.setProperty("webdriver.safari.driver", "src/main/resources/drivers/safaridriver");
                driver = new SafariDriver();
            }
            case "chrome-headless" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--proxy-server='direct://'");
                chromeOptions.addArguments("--proxy-bypass-list=*");
                driver = new ChromeDriver(chromeOptions);
            }
            case "edge" -> driver = new EdgeDriver();

            default ->
                    throw new IllegalArgumentException("Please specify valid browser name. Valid browser names are: firefox, chrome,chrome-headless, ie ,edge");

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();

        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

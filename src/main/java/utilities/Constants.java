package utilities;

public class Constants {
    public static final String PROPERTY_FILE = "src/main/resources/constants.properties";
    public static String User_Url;
    public static final String User_URL = JavaHelpers.getPropertyValue(PROPERTY_FILE, "url_Local" );

    //Selenium constants
    public static final int WEBDRIVER_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE, "WebDriverWaitDuration"));
    public static final int MINIMUM_WEBDRIVER_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE, "MinimumWebDriverWaitDuration"));
    public static final int PAGEFACTORY_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTY_FILE, "PageFactoryWaitDuration"));
    public static final String SCREENSHOT_LOCATION = JavaHelpers.getPropertyValue(PROPERTY_FILE, "ScreenshotLocation");

}

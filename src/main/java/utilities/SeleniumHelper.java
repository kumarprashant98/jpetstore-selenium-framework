package utilities;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class SeleniumHelper extends WaitHelpers {
    JavaHelpers helper;
    Actions actions;

    public SeleniumHelper(WebDriver driver) {
        super(driver);
        helper = new JavaHelpers();
    }

    // Take screenshot

    /**
     * Take screenshot of the web page
     *
     * @param fileName screenshot file name
     * @throws IOException Exception
     */
    @SuppressWarnings("UnstableApiUsage")
    public void takeScreenshot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile,
                new File(Constants.SCREENSHOT_LOCATION + "\\" + fileName + helper.getTimeStamp("_yyyyMMdd_HHmmss") + ".png"));
    }

    //Navigation

    /**
     * Navigate To Page
     *
     * @param url url
     */
    public static void navigateToPage(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Robot robot;
            try {
                robot = new Robot();
            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

    /**
     * Refresh Page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Back To Page
     */
    public void backToPage() {
        driver.navigate().back();
    }

    /**
     * Get Text from field
     *
     * @param e WebElement object
     * @return text from field
     */
    public String getText(WebElement e) {
        return waitTillElementIsVisible(e).getText().trim();
    }

    /**
     * Get Text from field
     *
     * @param by By object
     * @return text from field
     */
    public String getText(By by) {
        return waitTillElementIsVisible(by, Constants.WEBDRIVER_WAIT_DURATION).getText().trim();
    }

    //Elements

    /**
     * Enter text to input field
     *
     * @param e     WebElement object
     * @param text  input text
     * @param clear set true if want to clear field else set false
     */
    public void enterText(WebElement e, String text, boolean clear) {
        e = waitTillElementIsClickable(e);
        if (clear) {
            e.clear();
        }
        e.sendKeys(text);
    }

    /**
     * Click on Element
     *
     * @param e WebElement object
     * @throws InterruptedException Exception
     */
    public void clickOn(WebElement e) throws InterruptedException {
        waitTillElementIsClickable(e).click();
        waitForJavascriptToLoad();
    }

    /**
     * Click on Element
     *
     * @param e WebElement object
     * @throws InterruptedException Exception
     */
    public void clickOnWithoutWait(WebElement e) throws InterruptedException {
        e.click();
        waitForJavascriptToLoad();
    }

    /**
     * Click on Element
     *
     * @param by By object
     * @throws InterruptedException Exception
     */
    public void clickOn(By by) throws InterruptedException {
        waitTillElementIsClickable(by).click();
        waitForJavascriptToLoad();
    }

    /**
     * Enter text to input field
     *
     * @param by    By object
     * @param text  input text
     * @param clear set true if want to clear field else set false
     */
    public void enterText(By by, String text, boolean clear) {
        WebElement e = waitTillElementIsClickable(by);
        if (clear) {
            e.clear();
        }
        e.sendKeys(text);
    }

    /**
     * Select DropDown Value By Index
     *
     * @param e     element
     * @param index index
     */
    public String selectDropDownValueByIndex(WebElement e, int index) {
        new Select(e).selectByIndex(index);
        return new Select(e).getFirstSelectedOption().getText().trim();
    }

    /**
     * Method Verify that whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     */
    public Boolean isElementPresent(WebElement targetElement) {
        return waitInCaseElementVisible(targetElement, Constants.WEBDRIVER_WAIT_DURATION) != null && waitInCaseElementVisible(targetElement, Constants.WEBDRIVER_WAIT_DURATION).isDisplayed();
    }

    /**
     * method Verify that whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     */
    public Boolean isElementPresent(By targetElement) throws InterruptedException {
        return waitTillElementExist(targetElement, 10) != null && waitInCaseElementVisible(targetElement, 10) != null;
    }

    /**
     * Click on Element (without waiting for it's clickable)
     *
     * @param e WebElement object
     * @throws InterruptedException Exception
     */
    public void click(WebElement e) throws InterruptedException {
        e.click();
        waitForJavascriptToLoad();
    }

    /**
     * Select DropDown Value By Text
     *
     * @param e    WebElement object
     * @param text text
     */
    public void selectDropDownValueByText(WebElement e, String text) {
        new Select(e).selectByVisibleText(text);
    }

    /**
     * Get Selected DropDown Value
     *
     * @param e       WebElement object
     * @param signOut
     * @return selected value
     */
    public String getSelectedDropDownValue(WebElement e, String signOut) {
        return new Select(e).getFirstSelectedOption().getText().trim();
    }

    //Action events

    /**
     * Focus On Element
     *
     * @param e WebElement object
     */
    public void focusOnElement(WebElement e) {
        actions.moveToElement(e);
        actions.click();
    }

    /**
     * Double Click On Element
     *
     * @param e element object
     */
    public void doubleClickOnElement(WebElement e) {
        actions.doubleClick(e).build().perform();
    }

    /**
     * Double-Click On Element With Offset
     *
     * @param e     element object
     * @param x_off x-axis offset
     * @param y_off y-axis offset
     */
    public void doubleClickOnElementWithOffset(WebElement e, int x_off, int y_off) {
        actions.moveToElement(e, x_off, y_off).doubleClick().build().perform();
    }

    /**
     * Single-Click On Element With Offset
     *
     * @param e     element object
     * @param x_off x-axis offset
     * @param y_off y-axis offset
     */
    public void singleClickOnElementWithOffset(WebElement e, int x_off, int y_off) {
        actions.moveToElement(e, x_off, y_off).click().build().perform();
    }

    /**
     * Single Click On Element
     *
     * @param e element object
     */
    public void singleClickOnElement(WebElement e) {
        actions.moveToElement(e).click().build().perform();
    }

    /**
     * Drag And Drop
     *
     * @param drag web element for drag
     * @param drop web element for drop
     * @throws IllegalStateException Exception
     */
    public void dragAndDrop(WebElement drag, WebElement drop) throws InterruptedException {
        actions.clickAndHold(drag).build().perform();
        hardWait(3);
        actions.moveToElement(drop).build().perform();
        hardWait(3);
        actions.release(drop).build().perform();
        hardWait(3);
    }

    public void scrollToElement(WebElement element) {
        actions.scrollToElement(element).build().perform();
    }

    /**
     * Open New Tab
     */
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
    }

    // iFrames

    /**
     * Switch To Iframe
     *
     * @param iframeId iframe id
     */
    public void switchToIframe(String iframeId) {
        driver.switchTo().frame(iframeId);
    }

    /**
     * Switch To Iframe
     *
     * @param iframeIndex iframe index
     */
    public void switchToIframe(int iframeIndex) {
        driver.switchTo().frame(iframeIndex);
    }

    /**
     * Switch To Iframe
     *
     * @param e WebElement object
     */
    public void switchToIframe(WebElement e) {
        driver.switchTo().frame(e);
    }

    /**
     * Switch To Main Iframe
     */
    public void switchToMainIframe() {
        driver.switchTo().defaultContent();
    }

    // Browser's Tab handler

    /**
     * Get Window Handle
     */
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * Get Window Handles
     *
     * @return list of window handles
     */
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * Switch To Window
     *
     * @param tabNumber tab number
     */
    public void switchToWindow(int tabNumber) {
        int i = 1;
        for (String winHandle : getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if (i == tabNumber) break;
            i++;
        }
    }

    /**
     * Switch To Window
     *
     * @param windowHandle window handle address to switch
     */
    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    /**
     * Javascript Click On
     *
     * @param e WebElement object
     */
    public void javascriptClickOn(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
    }

    public void javascriptClickOn(By by) {
        var element = waitTillElementIsVisible(by, Constants.WEBDRIVER_WAIT_DURATION);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Page Scroll In View
     *
     * @param targetElement element to be present
     */
    public void pageScrollInView(By targetElement) {
        WebElement e = waitTillElementIsVisible(targetElement, Constants.WEBDRIVER_WAIT_DURATION);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", e);
    }


    /**
     * Page Scroll In View
     *
     * @param e WebElement object
     */
    public void pageScrollInView(WebElement e) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", e);
    }

    /**
     * Page Scroll Upto Bottom End
     */
    public void pageScrollUptoBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Get Scroll Bar Height
     *
     * @return scroll bar height
     */
    public int getScrollBarHeight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((Number) js.executeScript("return window.innerHeight")).intValue();
    }

    /**
     * Clear text box using Keys
     *
     * @param e WebElement Object
     */
    public void clearTextBoxUsingKeys(WebElement e) {
        waitTillElementIsClickable(e).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    /**
     * Clear text box using Keys
     *
     * @param by by
     */
    public void clearTextBoxUsingKeys(By by) {
        waitTillElementIsClickable(by).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
    /**
     * Scroll By Pixel
     *
     * @param pixel pixel
     */
    public void scrollByPixel(int pixel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    /**
     * Get Sorted List
     *
     * @param list list
     * @return sorted list
     */
    public List<String> getSortedList(List<String> list){
        Collator collator = Collator.getInstance(Locale.getDefault());
        collator.setStrength(Collator.TERTIARY);
        list.sort(collator);
        return list.stream().toList();
    }

    /**
     * Get Reverse Sorted List
     *
     * @param reversedList reversed list
     * @return reverse sorted list
     */
    public List<String> getReverseSortedList(List<String> reversedList){
        Collator collator = Collator.getInstance(Locale.getDefault());
        collator.setStrength(Collator.TERTIARY);
        reversedList.sort(collator.reversed());
        return reversedList.stream().toList();
    }
}


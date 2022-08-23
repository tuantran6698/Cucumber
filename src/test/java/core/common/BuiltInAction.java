package core.common;

import core.locators.Locator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;
import java.io.File;
import java.util.List;
import java.util.Objects;

import static core.common.Constant.SHORT_TIMEOUT;
import static core.common.Constant.WEBDRIVER;

public class BuiltInAction {
    /**
     * Maximizes the current window. This method is for desktop browsers only.
     */
    public static void maximizeWindow() {
        try {
            WEBDRIVER.manage().window().maximize();
        } catch (Exception err) {
            System.out.println("Error maximizeWindow: \n" + err);
            close();
        }
    }


    /**
     * Load a new web page in the current browser window.
     *
     * @param url url path or global url.
     */
    public static void visitPage(String url) {
        try {
            WEBDRIVER.get(url);
        } catch (Exception err) {
            System.out.println("Error Load new web page: \n" + err);
            close();
        }
    }

    /**
     * Opens a web page in a browser. Requires a relative or absolute url. If url starts with /, it opens a web page of a site defined by the url config parameter.
     *
     * @param url url path or global url.
     */
    public static void navigateTo(String url) {
        try {
            WEBDRIVER.navigate().to(url);
        } catch (Exception err) {
            System.out.println("Error Navigate By URL: \n" + err);
            close();
        }
    }

    /**
     * Gets the current URL from the browser.
     */
    public static String getCurrentUrl() {
        try {
            return WEBDRIVER.getCurrentUrl();
        } catch (Exception err) {
            System.out.println("Error Get Current URL: \n" + err);
            return null;
        }
    }

    /**
     * Find Element
     *
     * @param locator Located by CSS|XPath|ILocator
     */
    public static WebElement getWebElement(By locator) {
        try {
            return WEBDRIVER.findElement(locator);
        } catch (Exception err) {
            System.out.println("Error Get element: \n" + err);
            return null;
        }
    }

    /**
     * Find all elements within the current page using the given mechanism.
     *
     * @param locator Located by CSS|XPath|ILocator
     * @return The total of elements
     */
    public static List<WebElement> getAllWebElements(By locator) {
        try {
            return WEBDRIVER.findElements(locator);
        } catch (Exception err) {
            System.out.println("Error Get All Element: \n" + err);
            return null;
        }
    }

    /**
     * Retrieves a page title and returns it as string.
     *
     * @return Web title
     */
    public static String getTitle() {
        try {
            return WEBDRIVER.getTitle();
        } catch (Exception err) {
            System.out.println("Error Get Title: \n" + err);
            return null;
        }
    }

    /**
     * Gets the text from a popup created by window.alert|window.confirm|window.prompt. If no popup is visible, it returns an error.
     *
     * @return Popup text
     */
    public static String getPopUpText() {
        try {
            return WEBDRIVER.switchTo().alert().getText();
        } catch (Exception err) {
            System.out.println("Error Get Popup text: \n" + err);
            return null;
        }
    }

    /**
     * Fills a text field or <textarea> with the given string. If there is already text, it will be cleared first.
     *
     * @param locator  Located by CSS|XPath|ILocator
     * @param contents value
     */
    public static void enter(By locator, String contents) {
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            Objects.requireNonNull(getWebElement(locator)).sendKeys(contents);
        } catch (Exception error) {
            System.out.println("Error Enter the value: " + error);
        }
    }

    public static void quit() {
        if (WEBDRIVER != null) {
            WEBDRIVER.quit();
        }
    }

    /**
     * Close current browser
     */
    public static void close() {

        if (WEBDRIVER != null) {
            WEBDRIVER.close();
        }
    }

    /**
     * Waits for an element to be present on the page (the default amount is 1 second).
     *
     * @param locator          Located by CSS|XPath|ILocator
     * @param timeoutInSeconds (optional) time in seconds to wait
     */
    public static WebElement waitForElement(By locator, int timeoutInSeconds) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(WEBDRIVER, timeoutInSeconds);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception err) {
            System.out.println("Error waitForElement : \r\n" + err);
        }
        return element;
    }


    /**
     * Clicks on a link or a button, identified by a locator.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    public static void click(By locator) {
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            getWebElement(locator).click();
        } catch (Exception err) {
            System.out.println("Error Click Element : \r\n" + err);
        }
    }

    /**
     * Clears an HTML <textarea> or text <input> element's value.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    public static void clearField(By locator) {
        try {
            Objects.requireNonNull(getWebElement(locator)).clear();
        } catch (Exception err) {
            System.out.println("Error Clear Element : \r\n" + err);
        }
    }

    /**
     * Selects items in a list box or a combo box that are defined by the HTML <select> tag.
     *
     * @param locator  Located by CSS|XPath|ILocator.
     * @param selectBy index | value | text
     * @param value    value
     */
    public static void select(By locator, String selectBy, String value) {
        try {
            waitForElement(locator, SHORT_TIMEOUT);
            Select dropdown = new Select(Objects.requireNonNull(getWebElement(locator)));
            if (Objects.equals(selectBy, "index")) {
                dropdown.selectByIndex(Integer.parseInt(value));
            } else if (Objects.equals(selectBy, "value")) {
                dropdown.selectByValue(value);
            } else if (Objects.equals(selectBy, "text")) {
                dropdown.selectByVisibleText(value);
            } else {
                System.out.println("Cannot define!");
            }
        } catch (Exception err) {
            System.out.println("Error Select item : \n" + err);
        }
    }

    /**
     * Retrieves text from the specified element.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    public static String getText(By locator) {
        try {
            return Objects.requireNonNull(getWebElement(locator)).getText();
        } catch (Exception err) {
            System.out.println("Error Get Element Text : \n" + err);
            return null;
        }
    }

    /**
     * Retrieves an attribute from each of the located elements.
     *
     * @param locator   Located by CSS|XPath|ILocator.
     * @param attribute attribute name.
     */
    public static String getElementAttribute(By locator, String attribute) {
        try {
            return Objects.requireNonNull(getWebElement(locator)).getAttribute(attribute);
        } catch (Exception err) {
            System.out.println("Error Get Element Attribute : \n" + err);
            return null;
        }
    }

    /**
     * Returns a Boolean value to indicate whether or not the specified control is found. Returns a Boolean value of true if the control is found. Otherwise it returns false.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    public static boolean doesControlExist(By locator) {
        try {
            return Objects.requireNonNull(getWebElement(locator)).isDisplayed();
        } catch (Exception err) {
            System.out.println("Error Get Element Attribute : \n" + err);
            return false;
        }
    }

    /**
     * Checks if a control exists. If the control is found, the verify point is considered: Passed; otherwise the test is: Failed.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    public static void checkControlExistz(By locator) {
        try {
            Boolean realLocator = Objects.requireNonNull(getWebElement(locator)).isDisplayed();
            if (realLocator == true) {
                System.out.println("Control is existed: " + locator);
            }
        } catch (Exception err) {
            System.out.println("Error checkControlExist : \n" + err);
            close();
        }
    }

    /**
     * Checks if a control does not exist. If the specified control is not found, the verify point is considered: Passed; otherwise the test result is: Failed.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    @Nullable
    public static void checkControlNotExistz(By locator) {
        try {
            Boolean realLocator = getWebElement(locator).isDisplayed();
            if (!realLocator) {
                System.out.println("Control is NOT existed: " + locator);
            }
        } catch (Exception err) {
            System.out.println("Error checkControlNotExist : \n" + err);
            close();
        }
    }

    /**
     * Checks if an attribute exists. If the attribute is found, the verify point is considered: Passed; otherwise the test is: Failed.
     *
     * @param locator   Located by CSS|XPath|ILocator.
     * @param attribute attribute name.
     */
    public static boolean isAttributeExist(By locator, String attribute) {
        Boolean result = false;
        try {
            String value = Objects.requireNonNull(getWebElement(locator)).getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception err) {
            System.out.println("Error is Attribute Exist: \n" + err);
        }
        return result;
    }

    /**
     * Checks if the first element with given locator has an attribute whose value matches the provided one. The verify point is considered: Passed if the values match; otherwise the test result is: Failed.
     *
     * @param locator   Located by CSS|XPath|ILocator.
     * @param attribute Element's attribute to be retrieved.
     * @param value     Expected value of the attribute.
     */
    public static void checkControlProperty(By locator, String attribute, String value) {
        try {
            boolean realLocator = isAttributeExist(locator, attribute);
            if (!realLocator) {
                String realValue = Objects.requireNonNull(getWebElement(locator)).getAttribute(attribute);
                if (Objects.equals(realValue, value)) {
                    System.out.println("Control Property is match: " + value);
                }
            }
        } catch (Exception err) {
            System.out.println("Error checkControlProperty : \n" + err);
        }
    }

    /**
     * Checks that the title of a window/page is equal to the provided one. The verify point is considered: Passed if the values match; otherwise the test result is: Failed.
     *
     * @param title The title attribute of the current document.
     */
    public static void checkWindowExist(String title) {
        try {
            String realTitle = getTitle();
            if (Objects.equals(realTitle, title)) {
                System.out.println("Title is exist: " + title);
            }
        } catch (Exception err) {
            System.out.println("Error checkWindowExist : \n" + err);
            close();
        }
    }
    public static void switchIframe(By locator) {
        WebElement iFrame = getWebElement(locator);
            WEBDRIVER.switchTo().frame(iFrame);

    }
    public static void switchOutIframe() {
        WEBDRIVER.switchTo().defaultContent();

    }
    /**
     * Clicks on the active JavaScript native popup window, created by window.alert|window.confirm|window.prompt.
     *
     * @param option Click options:
     *               <p>
     *               "ok": click on the accept button of the popup
     *               "cancel": click on the cancel button of the popup
     */
    public static void clickPopup(String option) {
        try {
            if (Objects.equals(option, "ok")) {
                WEBDRIVER.switchTo().alert().accept();
            } else if (Objects.equals(option, "cancel")) {
                WEBDRIVER.switchTo().alert().dismiss();
            }
        } catch (Exception err) {
            System.out.println("Error Click Popup : \n" + err);
            close();
        }

    }

    /**
     * Closes the current tab
     */
    public static void closeCurrentTab() {
        WEBDRIVER.close();
    }

    /**
     * Closes all tabs except for the current one.
     */
    public static void closeOtherTabs() {
        try {
            String originalHandle = WEBDRIVER.getWindowHandle();
            //Do something to open new tabs
            for (String handle : WEBDRIVER.getWindowHandles()) {
                if (!handle.equals(originalHandle)) {
                    WEBDRIVER.switchTo().window(handle);
                    WEBDRIVER.close();
                }
            }
            WEBDRIVER.switchTo().window(originalHandle);
        } catch (Exception err) {
            System.out.println("Error closeOtherTabs : \n" + err);
        }
    }

    /**
     * Clears all cookies. If a cookie is specified, it only deletes that cookie.
     */
    public static void deleteCookie() {
        WEBDRIVER.manage().deleteAllCookies();
    }

    /**
     * Performs a double-click on an element matched by CSS|XPath|ILocator. The context can be specified as second parameter to narrow the search.
     *
     * @param locator Located by CSS|XPath|ILocator.
     */
    public static void doubleClick(By locator) {
        try {
            Actions act = new Actions(WEBDRIVER);
            act.doubleClick(getWebElement(locator)).perform();
        } catch (Exception err) {
            System.out.println("Error Double Click : \n" + err);
        }
    }

    /**
     * Does one of the following actions:
     * <p>
     * Drags an element to a destination element.
     * Drags an element to a destination coordinate on the page.
     * Drags anything at a coordinate on the page to a destination element.
     * Drags and drops between 2 coordinates on the page.
     *
     * @param source      located by CSS|XPath|ILocator, or a coordinate (x,y)
     * @param destination located by CSS|XPath|ILocator, or a coordinate (x,y)
     */
    public static void dragAndDrop(By source, By destination) {
        try {
            Actions act = new Actions(WEBDRIVER);
            act.dragAndDrop(getWebElement(source), getWebElement(destination)).build().perform();
        } catch (Exception err) {
            System.out.println("Error dragAndDrop : \n" + err);
        }
    }

    public static void moveMouse(By locator) {

    }

    public static void openNewTab() {

    }

    public static void pressKey(String key) {

    }

    public static void refresh() {

    }

    public static void rightClick(By locator) {

    }

    public static void switchBrowserText(String option) {

    }

    /**
     * Saves a screenshot of the current browsing context to a PNG file and put into the output folder (set in gondola.json). Be aware that, if we set the 'fullPage' value to 'true', some browser drivers take screenshots of the whole document (e.g. Geckodriver-Firefox and Safaridriver) and others only of the current viewport (e.g. Chromedriver).
     *
     * @param path       Eg: c:\\tmp\\screenshot.png
     * @param screenName file name to save. Eg: screenshot.png
     */
    public static void saveScreenShot(String path, String screenName) {
        try {
            File scrFile = ((TakesScreenshot) WEBDRIVER).getScreenshotAs(OutputType.FILE);
            String fullPath = path + screenName;
            FileUtils.copyFile(scrFile, new File(fullPath));
        } catch (Exception err) {
            System.out.println("Error saveScreenShot: \n" + err);
        }
    }
    public static void saveFullScreenShot(String path) {
    }

    /**
     * Attaches a file to an element
     *
     * @param location element will be attached. It can be located by CSS|XPath|ILocator.
     * @param filePath path of attached file. This path is relative to the current project directory (where package.json is located)
     */
    public static void attachFile(By location, String filePath) {
        try {
            waitForElement(location, SHORT_TIMEOUT.shortValue());
            Objects.requireNonNull(getWebElement(location)).sendKeys(filePath);
        } catch (Exception err) {
            System.out.println("Error attachFile: \n" + err);
        }
    }

    // whatever.....
}

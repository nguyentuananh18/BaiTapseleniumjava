package anhNT.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import static anhNT.common.DriverManager.*;

public class WebUI extends TestBase {

    private static final int EXPLICIT_WAIT_TIMEOUT = 2;
    private static final int WAIT_PAGE_LEADED_TIMEOUT = 20;


    private static final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT));

    static Actions action;
    public static void openURL(String URL) {
        getDriver().get(URL);
        waitForPageLoad();
    }
    public static List<WebElement>listElement(By locator){
        waitForPageLoad();
        waitForElementVisible(locator);
        return getDriver().findElements(locator);
    }

    public static void switchToWindows(int number) {
        Set<String> windows = getDriver().getWindowHandles();
        String firstWindow = (String) windows.toArray()[number];
        getDriver().switchTo().window(firstWindow);
    }

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    // Phương thức kiểm tra sự hiện diện của phần tử
    public static boolean VerifyIsElementDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (Exception ignored){

        }

    }
    public static boolean isElementPresent( By locator) {
        try {
            // Tìm phần tử dựa trên selector
            WebElement element = getDriver().findElement(locator);
            // Nếu phần tử được tìm thấy, trả về true
            return element != null;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Nếu không tìm thấy phần tử, trả về false
            return false;
        }
    }

    public static void selectOptionValue(By locator, String value){
        WebElement element = element(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public static void selectOptionValue(By locator, int index){
        WebElement element = element(locator);
        Select select = new Select(element);
        select.selectByIndex(index);

    }

    public static void hoverToElement(By locator) {
        waitForElementVisible(locator);
        WebElement element = getDriver().findElement(locator);
        action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }
    public static void rightClickElement(By locator) {
        waitForElementVisible(locator);
        WebElement element = getDriver().findElement(locator);
        Actions action = new Actions(getDriver());
        action.contextClick(element).perform();
    }
    public static void dragAndDropElement(By sourceLocator, By targetLocator) {
        Actions actions = new Actions(getDriver());
        WebElement sourceElement = getDriver().findElement(sourceLocator);
        WebElement targetElement = getDriver().findElement(targetLocator);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    // Phương thức xóa giá trị ô văn bản
    public static void clearText(By locator) {
        WebElement element = getDriver().findElement(locator);
        element.clear();
    }

    // Phương thức nhập giá trị vào ô văn bản
    public static void enterText(By locator, String text) {
        waitForElementVisible(locator);
        element(locator).sendKeys(text);
    }

    // Phương thức nhấp chuột vào phần tử
    public static void clickElement(By locator) {
        waitForPageLoad();
        waitForElementVisible(locator);

        element(locator).click();
    }

    // Phương thức kiểm tra hiển thị của phần tử
    public static boolean isElementDisplayed(By locator) {
        waitForPageLoad();
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static boolean verifyElementIsDisplay(By by) {
        waitForPageLoad();
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean verifyElementIsSelected(By locator) {
        waitForPageLoad();
        WebElement element = getDriver().findElement(locator);
        return element.isSelected();

    }

    public static String getTextElement(By by) {
        waitForPageLoad();
        waitForElementVisible(by);
        return element(by).getText();
    }

    public static String getAttribute(By locator, String attributeName) {
        waitForPageLoad();
        // Sử dụng phương thức getAttribute() của WebElement để lấy giá trị thuộc tính
        String attributeValue = getDriver().findElement(locator).getAttribute(attributeName);
        return attributeValue;

    }

    // Load lại page Web
    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static int getListElements(By locator) {
        List<WebElement> listOfDivElements = getDriver().findElements(locator);
        return listOfDivElements.size();
    }

    public static WebElement element(By by) {
        return getDriver().findElement(by);
    }

    //Alert
    public static void AlertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public static void AlertAccept() {
        getDriver().switchTo().alert().accept();
    }

    public static void AlertSendKeys(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    public static String AlertClick() {
        return getDriver().switchTo().alert().getText();
    }
}

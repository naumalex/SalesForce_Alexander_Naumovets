package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected final static String VIEW_CAPTION_LOCATOR =
            "//lst-breadcrumbs//span[text()='%s']";
    protected final static By NEW_BUTTON = By.cssSelector("div.active a[title='New']");
    public static final String TAB_TITLE_LOCATOR = "a[title='%s']";
    public static final By ACTIVE_TAB_TITLE_LOCATOR =
            By.cssSelector("a.slds-tabs--default__link[aria-selected='true']");

    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 120);
    }

    public abstract void waitForPageLoaded();
  /*  public void waitForPageLoaded(String caption) {
        By locator = By.xpath(String.format(VIEW_CAPTION_LOCATOR, caption));
        waitForElementDisplayed(locator);
    }*/

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }

    public void waitForElementDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForAttributeToBe(By locator, String attribute, String value) {
        wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
    }
    public void waitForElementInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public String getActiveTabTitle() {
        return driver.findElement(ACTIVE_TAB_TITLE_LOCATOR).getAttribute("title");
    }
}

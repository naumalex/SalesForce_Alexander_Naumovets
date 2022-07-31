package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private final static By USER_ICON_LOCATOR = By.cssSelector(".photoContainer");
    private final static By SHOW_NAVIGATION_MENU_BUTTON_LOCATOR =
            By.cssSelector("button[title= 'Show Navigation Menu']");
    private final static String NAVIGATION_MENU_ITEM_LOCATOR = "a[data-label= '%s']";
    private final static String CLOSE_TAB_BUTTON_LOCATOR = "button[title= 'Close %s']";
    private final static By ALERT_MESSAGE_LOCATOR = By.cssSelector("div[role='alertdialog']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public void openLeadsTab() {
        openTabByName("Leads");
    }

    public void openTabByName(String tabName) {
        By tabLocator = By.cssSelector(String.format(NAVIGATION_MENU_ITEM_LOCATOR, tabName));
        driver.findElement(SHOW_NAVIGATION_MENU_BUTTON_LOCATOR).click(); //open menu
        driver.findElement(tabLocator).click();//select item in the menu
    }

    public void closeTabByName(String tabName) {
        By locator = By.cssSelector(String.format(CLOSE_TAB_BUTTON_LOCATOR, tabName));
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }

    public String getAlertMessage() {
        System.out.println(driver.findElement(ALERT_MESSAGE_LOCATOR).getText());
        String alertText = driver.findElement(ALERT_MESSAGE_LOCATOR).getText();
        return alertText;
    }

    public void closeAlert() {
        driver.findElement(ALERT_MESSAGE_LOCATOR).click();
        waitForElementInvisible(ALERT_MESSAGE_LOCATOR);
    }
}

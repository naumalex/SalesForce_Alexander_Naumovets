package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public abstract class BaseModal extends BasePage {

    protected static final By SAVE_BUTTON_LOCATOR =
            By.xpath("//button[@name='SaveEdit' or @title='Save']");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoaded() {
        waitForElementDisplayed(SAVE_BUTTON_LOCATOR);
        waitForElementClickable(SAVE_BUTTON_LOCATOR);
    }


    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }


}

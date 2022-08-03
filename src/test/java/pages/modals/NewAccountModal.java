package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NewAccountModal extends BaseModal {

    private static final String TEXT_INPUT_LOCATOR =
        "//label/span[text() = '%s']/parent::label/following-sibling::div//input";
    private static final By SAVE_BUTTON_LOCATOR = By.cssSelector("button[title = 'Save']");
    public NewAccountModal(WebDriver driver) {
        super(driver);
    }


    public void setAccountName(String accountName) {
        driver.findElement(By.xpath(String.format(TEXT_INPUT_LOCATOR, "Account Name")))
                .sendKeys(accountName);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }

    public String fillAndSaveNewAccountForm(String accountName) {
        setAccountName(accountName);
        clickSaveButton();
        wait.until((p) -> {
            return !(getActiveTabTitle().equals("New Account"));
        });
        return getActiveTabTitle();
    }
}

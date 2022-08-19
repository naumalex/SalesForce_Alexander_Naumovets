package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LightningCombobox extends BaseElement {

    private static final String COMBOBOX_BUTTON_LOCATOR =
            "//label[text() = '%1$s']/following-sibling::div//button" +
                    "| //span[text() = '%1$s']/parent::span/following-sibling::div";

    private static final String COMBOBOX_ITEM_LOCATOR =
            "//label[text() = '%s']/following-sibling::div//" +
            "lightning-base-combobox-item//*[@title='%2$s']" +
            "| //div[@class = 'select-options']//a[text()='%2$s']";

    public LightningCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        if (visibleText == null)
            return;
        expandListOfOptions();
        selectOption(visibleText);
    }

    private void expandListOfOptions() {
        By locator = By.xpath(String.format(COMBOBOX_BUTTON_LOCATOR, label));
        WebElement button = driver.findElement(locator);
        log.debug(String.format("Scroll to combobox %s", label));
        scrollIntoView(button);
        wait.waitForElementClickable(locator);
        log.debug(String.format(
                "Click %s combobox to expand the list of options", label));
        button.click();
    }

    private void selectOption(String option) {
        By locator = By.xpath(String.format(COMBOBOX_ITEM_LOCATOR, label, option));
        WebElement item = driver.findElement(locator);
        scrollIntoView(item);
        wait.waitForElementClickable(locator);
        log.debug(String.format(
                "Click %s option", option));
        item.click();
    }
}

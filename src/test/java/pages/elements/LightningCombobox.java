package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LightningCombobox extends BaseElement {

    private static final String COMBOBOX_BUTTON_LOCATOR =
            "//label[text() = '%s']/following-sibling::div//button";

    private static final String COMBOBOX_ITEM_LOCATOR =
            "//label[text() = '%s']/following-sibling::div//" +
            "lightning-base-combobox-item//*[@title='%s']";

    public LightningCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        expandListOfOptions();
        selectOption(visibleText);
    }

    private void expandListOfOptions() {
        By locator = By.xpath(String.format(COMBOBOX_BUTTON_LOCATOR, label));
        WebElement comboboxButton = driver.findElement(locator);
        System.out.printf("Click %s combobox to expand the list of options", label);
        scrollIntoView(comboboxButton);
        comboboxButton.click();
    }

    private void selectOption(String option) {
        By locator = By.xpath(String.format(COMBOBOX_ITEM_LOCATOR, label, option));
        System.out.printf("Select %s combobox option = %s", label, option);
        driver.findElement(locator).click();
    }

}

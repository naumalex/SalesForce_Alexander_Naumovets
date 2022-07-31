package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Combobox {
    public static final String COMBOBOX_LOCATOR =
            "//label[text() = '%s']/following-sibling::div//";
    public static final String COMBOBOX_BUTTON_LOCATOR =
            COMBOBOX_LOCATOR + "button";
    public static final String COMBOBOX_ITEM_LOCATOR =
            COMBOBOX_LOCATOR + "lightning-base-combobox-item//*[@title='%s']";

    final private WebDriver driver;
    final private String label;

    public Combobox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private void expandListOfOptions() {
        By locator = By.xpath(String.format(COMBOBOX_BUTTON_LOCATOR, label));
        driver.findElement(locator).click();
    }

    private void selectOption(String option) {
        By locator = By.xpath(String.format(COMBOBOX_ITEM_LOCATOR, label, option));
        driver.findElement(locator).click();
    }
    public void selectOptionByValue(String value) {
        expandListOfOptions();
        selectOption(value);
    }

}

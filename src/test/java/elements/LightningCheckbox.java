package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LightningCheckbox extends BaseElement {

    private static final String CHECKBOX_LOCATOR =
            "//div[contains(@class,'active')]//label/span[text() = '%s']/parent::label/following-sibling::div//input" +
                    "| //div[contains(@class,'active')]//label/span[text() = '%s']" +
                    "/parent::label/following-sibling::input";
    private static final String CHECKBOX_TO_GET_VALUE_LOCATOR =
            "//div[contains(@class,'active')]//label/span[text() = '%s']/parent::label/preceding-sibling::input";
    public LightningCheckbox(WebDriver driver, String label) {
        super(driver, label);
    }
    public void setValue(boolean value) {
        WebElement checkbox = driver.findElement(By
                .xpath(String.format(CHECKBOX_LOCATOR, label, label)));
        if (!(checkbox.isSelected() == value)) {
            log.debug(String.format("Scroll to checkbox %s", label));
            scrollIntoView(checkbox);
            log.debug(String.format("Click checkbox %s", label));
            checkbox.click();
        }
    }

    public boolean getValue() {
        WebElement checkbox = driver.findElement(By
                .xpath(String.format(CHECKBOX_TO_GET_VALUE_LOCATOR, label)));
        return checkbox.isSelected();
    }
}

package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LightningInput extends BaseElement{

    private final static String INPUT_LOCATOR = "//label[text() = '%1$s']/following-sibling::div/input"// +
            + "|//label/span[text() = '%1$s']/parent::label/following-sibling::div//input"
            + "|//label/span[text() = '%1$s']/parent::label/following-sibling::input";

    public LightningInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        if (value == null) {
            return;
        }
        WebElement inputElement = driver.findElement(
                By.xpath(String.format(INPUT_LOCATOR, label)));
        log.debug(String.format("Scroll to %s input", label));
        scrollIntoView(inputElement);
        log.debug(String.format("Enter %s to %s input", value, label));
        inputElement.sendKeys(value);
    }
}

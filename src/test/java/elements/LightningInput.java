package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        System.out.printf("Setting %s input value = %s", label, value);
        scrollIntoView(inputElement);
        inputElement.sendKeys(value);
    }
}

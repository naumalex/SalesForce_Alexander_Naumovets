package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LightningLookupAddress extends BaseElement {

    private final String LOOKUP_LOCATOR = (label.isBlank()) ?
            ""
            : "//label/span[text() = '%s']/parent::label//following-sibling::div//" +
            "span[@class='pillText']";

    public LightningLookupAddress(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(
                By.xpath(String.format(LOOKUP_LOCATOR, label)));
        System.out.printf("Setting %s lookup value = %s\n", label, value);
        scrollIntoView(inputElement);
        inputElement.sendKeys(value);
    }
}

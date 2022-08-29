package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LightningTextArea extends BaseElement {
    private final static String TEXT_AREA_LOCATOR =
            "//label[text() = '%1$s']//following-sibling::div/textarea" + //for new lead window
                    "| //span[text() = '%1$s']/parent::label/following-sibling::textarea"; //for new account window

    public LightningTextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        if (value == null) {
            return;
        }
        WebElement inputElement = driver.findElement(
                By.xpath(String.format(TEXT_AREA_LOCATOR, label)));
        log.debug(String.format("Scroll to element %s",label));
        scrollIntoView(inputElement);
        log.debug(String.format("Enter %s to text area %s", value, label));
        inputElement.sendKeys(value);
    }
}

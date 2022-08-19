package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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
        System.out.printf("Setting %s text area value = %s\n", label, value);
        scrollIntoView(inputElement);
        inputElement.sendKeys(value);
    }
}
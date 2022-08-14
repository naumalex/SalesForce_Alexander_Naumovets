package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightningFormattedElement extends BaseElement {

    private static final String FORMATTED_ELEMENT_LOCATOR =
            "//div[contains(@class,'active')]//span[text()='%s' and @class='test-id__field-label']" +
                    "/parent::div//following-sibling::div//*[contains(name(), 'formatted')]";
    public LightningFormattedElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        WebElement inputElement = driver.findElement(
                By.xpath(String.format(FORMATTED_ELEMENT_LOCATOR, label)));
        scrollIntoView(inputElement);
        return inputElement.getText().equals("") ? null //if got empty text from control suppose it was not filled
                : inputElement.getText();
    }

    public void waitUntilDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(FORMATTED_ELEMENT_LOCATOR, label))));
    }
}
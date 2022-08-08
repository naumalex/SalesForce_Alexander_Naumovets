package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LightningFormattedLinkElement extends BaseElement {

    private static final String FORMATTED_ELEMENT_LOCATOR =
            "//div[contains(@class,'active')]//span[text()='%s' and @class='test-id__field-label']" +
                    "/parent::div//following-sibling::div//*[contains(name(), 'formatted')]//a";

    public LightningFormattedLinkElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        String elementIsNotEmpty = String.format(FORMATTED_ELEMENT_LOCATOR, label);
        String elementIsEmpty = elementIsNotEmpty.substring(0,
                    elementIsNotEmpty.length() - "//a".length());
        WebElement inputElement;
        if (isElementPresent(By.xpath(elementIsNotEmpty))) {
            inputElement = driver.findElement(By.xpath(elementIsNotEmpty));
        }
        else {
            inputElement = driver.findElement(By.xpath(elementIsEmpty));
        }
        scrollIntoView(inputElement);
        return inputElement.getText().equals("") ? null : inputElement.getText();
    }
    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }
}

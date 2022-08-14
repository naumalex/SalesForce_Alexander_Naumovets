package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class LightningFormattedLinkElement extends BaseElement {

    private static final String FORMATTED_ELEMENT_LOCATOR =
            "//div[contains(@class,'active')]//span[text()='%1$s' and @class='test-id__field-label']" +
                    "/parent::div//following-sibling::div//*[contains(name(), 'formatted')]//a"
            + "| //div[contains(@class,'active')]//span[text()='%1$s' and @class='test-id__field-label']" +
                    "/parent::div//following-sibling::div//a";
    public LightningFormattedLinkElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        String locatorIfElementNotEmpty = String.format(FORMATTED_ELEMENT_LOCATOR, label);
        String locatorIfElementEmpty = locatorIfElementNotEmpty.substring(0,
                    locatorIfElementNotEmpty.length() - "//a".length());
        WebElement inputElement;
        if (isElementPresent(By.xpath(locatorIfElementNotEmpty))) {
            inputElement = driver.findElement(By.xpath(locatorIfElementNotEmpty));
        }
        else {
            inputElement = driver.findElement(By.xpath(locatorIfElementEmpty));
        }
        scrollIntoView(inputElement);
        return inputElement.getText().equals("") ? null
                : inputElement.getText();
    }
    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }
}

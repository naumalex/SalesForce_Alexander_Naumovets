package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LightningFormattedAddressElement extends BaseElement {

    private static final String FORMATTED_ELEMENT_LOCATOR =
            "//span[text()='%s'][@class='test-id__field-label']/"
            + "parent::div/following-sibling::div//lightning-formatted-address/a";

    public LightningFormattedAddressElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        return driver.findElement(
                By.xpath(String.format(FORMATTED_ELEMENT_LOCATOR,label))).getText();
    }
}

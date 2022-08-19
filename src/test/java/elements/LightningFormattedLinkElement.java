package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.Optional;
public class LightningFormattedLinkElement extends BaseElement {

    private static final String FORMATTED_ELEMENT_LOCATOR =
    "//div[contains(@class,'active')]//span[text()='%s' and @class='test-id__field-label']/parent::div" +
            "//following-sibling::div//*[self::span[contains(@class,'test-id__field-value')] or self::a]";
    public LightningFormattedLinkElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        String locator = String.format(FORMATTED_ELEMENT_LOCATOR, label);
        Optional<WebElement> inputElement = driver.findElements(By.xpath(locator))
                .stream().filter(s -> s.getTagName().equals("a")).findFirst();
        if (inputElement.isPresent()) {
            scrollIntoView(inputElement.get());
            return inputElement.get().getAttribute("innerText");
        }

        inputElement = driver.findElements(By.xpath(locator))
                    .stream().filter(s -> s.getTagName().equals("span")).findFirst();
        if (inputElement.isPresent()) {
            return null;
        }
        else {
            throw(new NoSuchElementException());
        }
    }
}

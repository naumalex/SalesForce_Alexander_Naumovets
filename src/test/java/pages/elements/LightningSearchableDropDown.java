package pages.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

@Log4j2
public class LightningSearchableDropDown extends BaseElement {

    private final String DROPDOWN_LOCATOR =
            "//label/span[text() = '%s']/parent::label//following-sibling::div//input";
   private final String DROPDOWN_ITEMS_LOCATOR =
           "//label/span[text() = '%s']/parent::label//following-sibling::div//div[@role='listbox']//li//mark";

    public LightningSearchableDropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public List<WebElement> getItems() {
        By locator = By.xpath(String.format(DROPDOWN_ITEMS_LOCATOR, label));
        wait.waitForListLoaded(locator);
        log.info(driver.findElements(locator).size());
        return driver.findElements(locator);
    }

    public void setValue(String value) {
        if (value == null)
            return;
        WebElement element = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, label)));
        scrollIntoView(element);
        element.sendKeys(value);
        List<WebElement> list = getItems();
        Optional<WebElement> options = list.stream()
                .filter(p->p.getText().equals(value)).findFirst();
        options.ifPresent(this::scrollIntoView);
        options.ifPresent(WebElement::click);
    }
}

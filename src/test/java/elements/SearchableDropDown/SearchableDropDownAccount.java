package elements.SearchableDropDown;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SearchableDropDownAccount extends BaseSearchableDropDown {

private final String DROPDOWN_ELEMENT_XPATH_EXPRESSION =
            "//label/span[text() = '%s']/parent::label//following-sibling::div//input";
   private final String DROPDOWN_ITEMS_XPATH_EXPRESSION =
           "//label/span[text() = '%s']/parent::label//following-sibling::div//div[@role='listbox']//li//mark";


    public SearchableDropDownAccount(WebDriver driver, String label) {
        super(driver, label);
    }

    @Override
    protected String getDropDownElementXpathExpression() {
        return DROPDOWN_ELEMENT_XPATH_EXPRESSION;
    }

    @Override
    protected String getDropDownItemsXpathExpression() {
        return DROPDOWN_ITEMS_XPATH_EXPRESSION;
    }
/*    public List<WebElement> getItems() {
        By locator = By.xpath(String.format(DROPDOWN_ITEMS_LOCATOR, label));
        wait.waitForListLoaded(locator);
        log.info(driver.findElements(locator).size());
        driver.findElements(locator).stream().map(WebElement::getText).forEach(log::info);
        driver.findElements(By.xpath(String.format(DROPDOWN_ITEMS_LOCATOR + "/parent::*", label))).stream().map(WebElement::getText).forEach(log::info);
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
*/
}


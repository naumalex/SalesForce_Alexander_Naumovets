package elements.SearchableDropDown;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

@Log4j2
public abstract class BaseSearchableDropDown extends BaseElement {
    protected abstract String getDropDownElementXpathExpression();
    protected abstract String getDropDownItemsXpathExpression();

    public BaseSearchableDropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public List<WebElement> getItems() {
        By locator = By.xpath(String.format(getDropDownItemsXpathExpression(), label));
        wait.waitForListLoaded(locator);
        //log.info(driver.findElements(locator).size());
       // driver.findElements(locator).stream().map(WebElement::getText).forEach(log::info);
       // driver.findElements(By.xpath(String.format(DROPDOWN_ITEMS_LOCATOR + "/parent::*", label))).stream().map(WebElement::getText).forEach(log::info);
        return driver.findElements(locator);
    }

    public void setValue(String value) {
        if (value == null)
            return;
        WebElement element = driver.findElement(By.xpath(String.format(
                getDropDownElementXpathExpression(), label)));
        scrollIntoView(element);
        element.sendKeys(value);
        List<WebElement> list = getItems();
        Optional<WebElement> options = list.stream()
                .filter(p->p.getText().equals(value)).findFirst();
        options.ifPresent(p -> { scrollIntoView(p); p.click();});
    }
}

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
}


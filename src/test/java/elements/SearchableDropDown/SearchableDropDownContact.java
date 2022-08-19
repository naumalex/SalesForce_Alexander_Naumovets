package elements.SearchableDropDown;

import org.openqa.selenium.WebDriver;

public class SearchableDropDownContact extends BaseSearchableDropDown{
    private final String DROPDOWN_ELEMENT_XPATH_EXPRESSION =
            "//label[text() = '%s']//following-sibling::div//input";
    private final String DROPDOWN_ITEMS_XPATH_EXPRESSION =
            "//label[text() = '%s']//following-sibling::div//div[@role='listbox']//li//lightning-base-combobox-formatted-text";

    public SearchableDropDownContact(WebDriver driver, String label) {
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

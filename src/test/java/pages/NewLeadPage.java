package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLeadPage extends BasePage {

    public static final By NEW_LEAD_TITLE_LOCATOR = By.cssSelector("a[title='New Lead']");
    public static final By SAVED_TAB_LEAD_TITLE_LOCATOR =
            By.cssSelector("a.slds-tabs--default__link[aria-selected='true']");
    public static final By LAST_NAME_LOCATOR = By.xpath("//input[@name='lastName']");
    public static final By COMPANY_LOCATOR = By.xpath("//input[@name='Company']");
    public static final By BUTTON_SAVE_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    private Actions actions;
    public NewLeadPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(NEW_LEAD_TITLE_LOCATOR);
        driver.findElement(NEW_LEAD_TITLE_LOCATOR).click();
    }

    public void setLeadStatus(String value) {
        Combobox leadStatusCombobox = new Combobox(driver, "Lead Status");
        leadStatusCombobox.selectOptionByValue(value);
    }

    public void setSalutation(String value) {
        Combobox salutationCombobox = new Combobox(driver, "Salutation");
        salutationCombobox.selectOptionByValue(value);
    }

    public void setLastName(String value) {
        WebElement lastNameInput = driver.findElement(LAST_NAME_LOCATOR);
        actions.moveToElement(lastNameInput).build().perform();
        lastNameInput.sendKeys(value);
    }

    public void setCompany(String value) {
        WebElement companyInput = driver.findElement(COMPANY_LOCATOR);
        actions.moveToElement(companyInput).build().perform();
        companyInput.sendKeys(value);
    }

    public void clickSave() {
        driver.findElement(BUTTON_SAVE_LOCATOR).click();
    }

    public String getSavedLeadPageTitle() {
        return driver.findElement(SAVED_TAB_LEAD_TITLE_LOCATOR).getAttribute("title");
    }
    public String fillAndSaveNewLeadForm(String leadStatus, String salutation,
                                       String lastName, String company) {
        setLeadStatus(leadStatus);
        setSalutation(salutation);
        setLastName(lastName);
        setCompany(company);
        clickSave();
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until((p) -> {
            return !(getSavedLeadPageTitle().equals("New Lead"));
        });
        return getSavedLeadPageTitle();
    }



}

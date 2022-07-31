package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsPage extends BasePage{


    private final static By LEADS_CAPTION_LOCATOR =
            By.xpath("//lst-breadcrumbs//span[text()='Leads']");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(LEADS_CAPTION_LOCATOR);
    }





}

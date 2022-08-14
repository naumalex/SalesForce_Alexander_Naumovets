package pages.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Utils.WaitUtils;

public class BaseElement {
    protected WebDriver driver;
    protected String label;
    protected WaitUtils wait;

    public BaseElement(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait =  new WaitUtils(driver);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

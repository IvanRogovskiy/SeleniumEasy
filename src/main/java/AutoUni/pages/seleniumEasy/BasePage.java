package AutoUni.pages.seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unchecked")
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        this.url = url;
    }

     public <T extends BasePage> T open(String baseUrl) {
        driver.get(baseUrl + url);
        return (T) this;
    }

    public boolean IsElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean IsElementVisible(By by){
        return driver.findElement(by).isDisplayed();
    }

}

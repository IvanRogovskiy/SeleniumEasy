package AutoUni.pages.seleniumEasy;

import AutoUni.helper.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

     public BasePage open(String baseUrl) {
        driver.get(baseUrl + url);
        return this;
    }

    public BasePage isOpened() {
        Assert.assertTrue(new CommonHelper(driver).isPageLoaded());
        return this;
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

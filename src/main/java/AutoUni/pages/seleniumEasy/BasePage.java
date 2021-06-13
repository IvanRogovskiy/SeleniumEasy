package AutoUni.pages.seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    private final By addBanner = By.cssSelector("#at-cv-lightbox-content"),
            addCloseButton = By.cssSelector("#at-cv-lightbox-close");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
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

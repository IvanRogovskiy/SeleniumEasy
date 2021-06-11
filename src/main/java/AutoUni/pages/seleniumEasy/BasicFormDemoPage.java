package AutoUni.pages.seleniumEasy;

import AutoUni.helper.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasicFormDemoPage extends BasePage {

    public BasicFormDemoPage(WebDriver driver) {
        super(driver);
    }

    public BasicFormDemoPage isOpened() {
        Assert.assertTrue(new CommonHelper(driver).isPageLoaded());
        return this;
    }

    private final By singleInputField = By.id("user-message"),
    myMessageField = By.cssSelector("#user-message #display"),

    sum1Field = By.id("sum1"),
    sum2Field = By.id("sum2"),
    totalSumField = By.id("displayvalue"),

    addBanner = By.cssSelector("#at-cv-lightbox-content"),
    addCloseButton = By.cssSelector("#at-cv-lightbox-close");

    public BasicFormDemoPage fillInField(String inputValue) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(singleInputField)).clear();
        driver.findElement(singleInputField).sendKeys(inputValue);
        return this;
    }

    public WebElement actionButton(Action action) {
        return webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'" + action.value +"')]")));
    }

    public BasicFormDemoPage showMessage() {
        actionButton(Action.SHOW_MESSAGE).click();
        return this;
    }

    public String getMessage() {
        if (super.IsElementVisible(addBanner)) {
            driver.findElement(addCloseButton).click();
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(addBanner));
        }
            return driver.findElement(myMessageField).getText();
    }

    public String getTotalSum() {
        if (super.IsElementVisible(addBanner)) {
            driver.findElement(addCloseButton).click();
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(addBanner));
        }
        return driver.findElement(totalSumField).getText();
    }

    public BasicFormDemoPage fillSum1Field(String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(sum1Field)).clear();
        driver.findElement(sum1Field).sendKeys(value);
        return this;
    }

    public BasicFormDemoPage fillSum2Field(String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(sum2Field)).clear();
        driver.findElement(sum2Field).sendKeys(value);
        return this;
    }

    public BasicFormDemoPage fillInSumFields(String value1, String value2) {
        fillSum1Field(value1);
        fillSum2Field(value2);
        return this;
    }

    public BasicFormDemoPage showTotal() {
        actionButton(Action.GET_TOTAL).click();
        return this;
    }

    private enum Action {

        SHOW_MESSAGE ("Show Message"),
        GET_TOTAL ("Get Total");

        private final String value;

        Action(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}

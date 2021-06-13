package AutoUni.pages.seleniumEasy;

import AutoUni.helper.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class InputFormPage extends BasePage {

    private final By firstNameFieldLocator = By.cssSelector("input[name= 'first_name']"),
    lastNameFieldLocator = By.cssSelector("input[name = 'last_name']"),
    emailFieldLocator = By.cssSelector("input[name = 'email']"),
    phoneFieldLocator = By.cssSelector("input[name = 'phone']"),
    addressFieldLocator = By.cssSelector("input[name = 'address']"),
    cityFieldLocator = By.cssSelector("input[name = 'city']"),
    zipCodeFieldLocator = By.cssSelector("input[name = 'zip']"),
    commentFieldLocator = By.cssSelector("textarea[name = 'comment']"),
    domainFieldLocator = By.cssSelector("input[name = 'website']"),

    chooseStateButtonLocator = By.cssSelector("select[name='state']"),
    statesListLocator = By.cssSelector("select[name='state'] option"),

    hostingAvailableButtonLocator = By.cssSelector("input[type='radio'][value='yes']"),
    hostingUnAvailableButtonLocator = By.cssSelector("input[type='radio'][value='no']"),

    submitButtonLocator = By.cssSelector(".form-group button[type ='submit']");


    public InputFormPage(WebDriver driver) {
        super(driver);
    }

    private InputFormPage fillInInputField(By fieldLocator, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(fieldLocator)).clear();
        driver.findElement(fieldLocator).sendKeys(value);
        return this;
    }

    public boolean isValid(String fieldName) {
         return driver.findElement(By.xpath("//i[@data-bv-icon-for='" + fieldName + "']"))
                .getAttribute("class")
                .contains("glyphicon-ok");
    }

    public InputFormPage fillInFirstName(String value) {
        fillInInputField(firstNameFieldLocator, value);
        return this;
    }

    public InputFormPage fillInLastName(String value) {
        fillInInputField(lastNameFieldLocator, value);
        return this;
    }

    public InputFormPage fillInEmail(String value) {
        fillInInputField(emailFieldLocator, value);
        return this;
    }

    public InputFormPage fillInPhone(String value) {
        fillInInputField(phoneFieldLocator, value);
        return this;
    }

    public InputFormPage fillInAddress(String value) {
        fillInInputField(addressFieldLocator, value);
        return this;
    }

    public InputFormPage fillInCity(String value) {
        fillInInputField(cityFieldLocator, value);
        return this;
    }

    public InputFormPage fillInZip(String value) {
        fillInInputField(zipCodeFieldLocator, value);
        return this;
    }

    public InputFormPage chooseRandomState() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(chooseStateButtonLocator)).click();
        List<WebElement> stateElements = webDriverWait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(statesListLocator));
        CommonHelper.pickRandomElementFromDropdown(stateElements).click();
        return this;
    }

    public InputFormPage chooseIsHostingAvailable(boolean isAvailable) {
       if (isAvailable) {
           driver.findElement(hostingAvailableButtonLocator).click();
       } else {
           driver.findElement(hostingUnAvailableButtonLocator).click();
       }
       return this;
    }

    public InputFormPage fillInTheForm(String firstName,
                                String lastName,
                                String email,
                                String phone,
                                String address,
                                String city,
                                String zipcode,
                                String domain,
                                String commentField) {
        fillInInputField(firstNameFieldLocator, firstName);
        fillInInputField(lastNameFieldLocator, lastName);
        fillInInputField(emailFieldLocator, email);
        fillInInputField(phoneFieldLocator, phone);
        fillInInputField(addressFieldLocator, address);
        fillInInputField(cityFieldLocator, city);
        chooseRandomState();
        fillInInputField(zipCodeFieldLocator, zipcode);
        fillInInputField(domainFieldLocator, domain);
        chooseIsHostingAvailable(true);
        fillInInputField(commentFieldLocator, commentField);
        return this;
    }

    public InputFormPage sendForm() {
        if (!driver.findElement(submitButtonLocator).isEnabled()) {
            throw new ElementNotInteractableException("Button is disabled");
        }
        driver.findElement(submitButtonLocator).click();
        return this;
    }

}

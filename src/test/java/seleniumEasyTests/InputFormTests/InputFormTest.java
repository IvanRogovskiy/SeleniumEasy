package seleniumEasyTests.InputFormTests;

import AutoUni.DriverInit;
import AutoUni.pages.seleniumEasy.InputFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputFormTest extends DriverInit {

    @Test(groups = {"InputFormTests"}, dataProvider = "firsLastNamesTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void firstNameFieldTestPositive(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertTrue(new InputFormPage(driver)
                .fillInFirstName(value)
                .isValid("first_name")); //TODO Create enum
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "firsLastNamesTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void firstNameFieldTestNegative(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertFalse(new InputFormPage(driver)
                .fillInFirstName(value)
                .isValid("first_name"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "firsLastNamesTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void lastNameFieldTestPositive(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertTrue(new InputFormPage(driver)
                .fillInLastName(value)
                .isValid("last_name")); //TODO Create enum
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "firsLastNamesTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void lastNameFieldTestNegative(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertFalse(new InputFormPage(driver)
                .fillInLastName(value)
                .isValid("last_name"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "emailTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void emailFieldTestPositive(String value) {
        System.out.println(value);
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertTrue(new InputFormPage(driver)
                .fillInEmail(value)
                .isValid("email")); //TODO Create enum
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "emailTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void emailFieldTestNegative(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        System.out.println(value);
        Assert.assertFalse(new InputFormPage(driver)
                .fillInEmail(value)
                .isValid("email")); //TODO Create enum
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "formAllFieldValidTest", dataProviderClass = InputFormDataProvider.class)
    public void successfullySendFormWithValidData(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) throws InterruptedException {
        driver.get(baseUrl + "/input-form-demo.html");
        new InputFormPage(driver)
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .sendForm();
    }
}

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

    @Test(groups = {"InputFormTests"}, dataProvider = "phoneTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void phoneFieldTestPositive(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertTrue(new InputFormPage(driver)
                .fillInPhone(value)
                .isValid("phone"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "phoneTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void phoneFieldTestNegative(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertFalse(new InputFormPage(driver)
                .fillInPhone(value)
                .isValid("phone"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "addressTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void addressFieldTestPositive(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertTrue(new InputFormPage(driver)
                .fillInAddress(value)
                .isValid("address"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "addressTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void addressFieldTestNegative(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertFalse(new InputFormPage(driver)
                .fillInAddress(value)
                .isValid("address"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "cityTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void cityFieldTestPositive(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertTrue(new InputFormPage(driver)
                .fillInCity(value)
                .isValid("city"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "cityTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void cityFieldTestNegative(String value) {
        driver.get(baseUrl + "/input-form-demo.html");
        Assert.assertFalse(new InputFormPage(driver)
                .fillInCity(value)
                .isValid("address"));
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "formAllFieldValidTest", dataProviderClass = InputFormDataProvider.class)
    public void successfullySendFormWithValidData(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) throws InterruptedException {
        driver.get(baseUrl + "/input-form-demo.html");
        new InputFormPage(driver)
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .sendForm();
    }
}

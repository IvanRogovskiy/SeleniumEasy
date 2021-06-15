package seleniumEasyTests.InputFormTests;

import AutoUni.DriverInit;
import AutoUni.data.InputFormFieldName;
import AutoUni.pages.seleniumEasy.InputFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputFormTest extends DriverInit {

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "firsLastNamesTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void firstNameFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInFirstName(value)
                .isValid(InputFormFieldName.FIRST_NAME.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "firsLastNamesTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void firstNameFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertFalse(inputFormPage
                .fillInFirstName(value)
                .isValid(InputFormFieldName.FIRST_NAME.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "firsLastNamesTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void lastNameFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInLastName(value)
                .isValid(InputFormFieldName.LAST_NAME.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "firsLastNamesTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void lastNameFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertFalse(inputFormPage
                .fillInLastName(value)
                .isValid(InputFormFieldName.LAST_NAME.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "emailTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void emailFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInEmail(value)
                .isValid(InputFormFieldName.E_MAIL.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "emailTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void emailFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertFalse(inputFormPage
                .fillInEmail(value)
                .isValid(InputFormFieldName.E_MAIL.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "phoneTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void phoneFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInPhone(value)
                .isValid(InputFormFieldName.PHONE.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "phoneTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void phoneFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertFalse(inputFormPage
                .fillInPhone(value)
                .isValid(InputFormFieldName.PHONE.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "addressTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void addressFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInAddress(value)
                .isValid(InputFormFieldName.ADDRESS.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "addressTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void addressFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertFalse(inputFormPage
                .fillInAddress(value)
                .isValid(InputFormFieldName.ADDRESS.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "cityTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void cityFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInCity(value)
                .isValid(InputFormFieldName.CITY.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "cityTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void cityFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertFalse(inputFormPage
                .fillInCity(value)
                .isValid(InputFormFieldName.CITY.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "zipTestPositive", dataProviderClass = InputFormDataProvider.class)
    public void zipFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInZip(value)
                .isValid(InputFormFieldName.ZIP_CODE.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "zipTestNegative", dataProviderClass = InputFormDataProvider.class)
    public void zipFieldTestNegative(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl);
        Assert.assertFalse(inputFormPage
                .fillInZip(value)
                .isValid(InputFormFieldName.ZIP_CODE.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "websiteFieldTest", dataProviderClass = InputFormDataProvider.class)
    public void websiteFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInWeb(value)
                .isValid(InputFormFieldName.DOMAIN.getFieldName()));
    }

    @Test(groups = {"InputFormFieldTests"}, dataProvider = "descriptionFieldTest", dataProviderClass = InputFormDataProvider.class)
    public void descriptionFieldTestPositive(String value) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl);
        Assert.assertTrue(inputFormPage
                .fillInWeb(value)
                .isValid(InputFormFieldName.DESCRIPTION.getFieldName()));
    }

    //Whole form tests

    @Test(groups = {"InputFormTests"}, dataProvider = "formAllFieldValidTest", dataProviderClass = InputFormDataProvider.class)
    public void successfullySendFormWithValidData(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) throws InterruptedException {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        inputFormPage
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .sendForm();
    }

    @Test(groups = {"InputFormTests"})
    public void failToSendFormWithAllBlankFields() {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .sendForm()
                .isFormSendingDisabled());
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "formAllFieldInValidTest", dataProviderClass = InputFormDataProvider.class)
    public void failToSendFormWithAllFieldsWithAllInvalidValues(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .sendForm()
                .isFormSendingDisabled());
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "formOneFieldInValidTest", dataProviderClass = InputFormDataProvider.class)
    public void failToSendFormWithOneInvalidValue(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .sendForm()
                .isFormSendingDisabled());
    }

    @Test(groups = {"InputFormTests"}, dataProvider = "formOneFieldValidTest", dataProviderClass = InputFormDataProvider.class)
    public void failToSendFormWithOneValidValue(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) {
        InputFormPage inputFormPage = new InputFormPage(driver);
        inputFormPage.open(baseUrl).isOpened();
        Assert.assertTrue(inputFormPage
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .isFormSendingDisabled());
    }

}

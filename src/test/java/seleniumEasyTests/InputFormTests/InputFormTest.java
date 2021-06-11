package seleniumEasyTests.InputFormTests;

import AutoUni.DriverInit;
import AutoUni.pages.seleniumEasy.InputFormPage;
import org.testng.annotations.Test;

public class InputFormTest extends DriverInit {

    @Test(groups = {"InputFormTests"}, dataProvider = "inputFieldTest", dataProviderClass = InputFormDataProvider.class)
    public void successfullySendFormWithValidData(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String domain, String commentField) throws InterruptedException {
        driver.get(baseUrl + "/input-form-demo.html");
        new InputFormPage(driver)
                .fillInTheForm(firstName, lastName, email, phone, address, city, zipcode, domain, commentField)
                .sendForm();
    }
}

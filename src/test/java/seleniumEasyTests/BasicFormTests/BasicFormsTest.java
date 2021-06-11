package seleniumEasyTests.BasicFormTests;

import AutoUni.DriverInit;
import AutoUni.pages.seleniumEasy.BasicFormDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicFormsTest extends DriverInit {

    @Test(groups = {"BasicFormTests"}, dataProvider = "singleFieldTest", dataProviderClass = BasicFormTestDataProvider.class)
    public void checkSingleInputField(String fieldValue) {
        driver.get(baseUrl + "/basic-first-form-demo.html");
        String actualMessage = new BasicFormDemoPage(driver)
                .isOpened()
                .fillInField(fieldValue)
                .showMessage()
                .getMessage();
        Assert.assertEquals(actualMessage, fieldValue);
    }

    @Test(groups = {"BasicFormTests"}, dataProvider = "twoFieldsTest", dataProviderClass = BasicFormTestDataProvider.class)
    public void checkTwoInputFields(Integer field1Value, Integer field2Value) {
        //TODO move to open method in Base class
        driver.get(baseUrl + "/basic-first-form-demo.html");
        String actualSum = new BasicFormDemoPage(driver)
                .isOpened()
                .fillInSumFields(field1Value.toString(), field2Value.toString())
                .showTotal()
                .getTotalSum();
        Assert.assertEquals(Integer.parseInt(actualSum), (field1Value + field2Value));
    }

    @Test(groups = {"BasicFormTests"}, dataProvider = "twoFieldsTestNegative", dataProviderClass = BasicFormTestDataProvider.class)
    public void checkTwoInputFieldsNegative(String field1Value, String field2Value) {
        driver.get(baseUrl + "/basic-first-form-demo.html");
        String actualSum = new BasicFormDemoPage(driver)
                .isOpened()
                .fillInSumFields(field1Value, field2Value)
                .showTotal()
                .getTotalSum();
        Assert.assertEquals(actualSum, "NaN");
    }

}

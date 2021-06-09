package seleniumEasyTests;

import AutoUni.DriverInit;
import AutoUni.pages.seleniumEasy.BasicFormDemoPage;
import org.apache.commons.exec.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.Random;

public class SingleFormTest extends DriverInit {

    @DataProvider(name = "singleFieldTest")
    public Object[][] createData() {
        return new Object[][] {
                { "" },
               { "b" },
                {"Please enter your message"},
                { "It is a very long message that COnTAINS chars in lower and UPPPER cases and some numbers 1232467890" },
                { "~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?" },
                {"测试 ♡€ ☺"}
        };
    }


    @Test(groups = {"seleniumEasyTests"}, dataProvider = "singleFieldTest")
    public void checkSingleInputField(String fieldValue) {
        driver.get(baseUrl);
        String actualMessage = new BasicFormDemoPage(driver)
                .isOpened()
                .fillInField(fieldValue)
                .showMessage()
                .getMessage();
        Assert.assertEquals(actualMessage, fieldValue);
    }
}

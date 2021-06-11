package seleniumEasyTests.InputFormTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InputFormDataProvider {

    @DataProvider(name = "inputFieldTest")
    public static Object[][] createData() {
        return new Object[][] {

                {       RandomStringUtils.randomAlphabetic(10),  //firstName
                        RandomStringUtils.randomAlphabetic(10),  //lastName
                        RandomStringUtils.randomAlphabetic(5) + "@test.com", //email
                        //TODO Randomizer
                        "9522422353", //phoneNumber
                        "Leninskiy street, 15", //address
                        "Voronezh", //city
                        "12312", //ZIP-code
                        "@test", //domain
                        "qwewqeqecqwdq" //description
                },

//                {       RandomStringUtils.randomAlphanumeric(10),  //firstName
//                        RandomStringUtils.randomAlphanumeric(10),  //lastName
//                        RandomStringUtils.randomAlphanumeric(5) + "@test.com", //email
//                        //TODO Randomizer
//                        RandomStringUtils.randomAlphanumeric(5), //phoneNumber
//                        "Leninskiy street, 15", //address
//                        "Voronezh", //city
//                        "12312", //ZIP-code
//                        "@test", //domain
//                        "qwewqeqecqwdq" //description
//                },
//                {"b"},
//                {"Please enter your message"},
//                {"It is a very long message that COnTAINS chars in lower and UPPPER cases and some numbers 1232467890"},
//                {"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?"},
//                {"测试 ♡€ ☺"}
        };
    }
}

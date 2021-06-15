package seleniumEasyTests.BasicFormTests;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class BasicFormTestDataProvider {

    @DataProvider(name = "singleFieldTest")
    public static Object[][] createData() {
        return new Object[][]{
                {""},
                {"b"},
                {"Please enter your message"},
                {"It is a very long message that COnTAINS chars in lower and UPPPER cases and some numbers 1232467890"},
                {"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?"},
                {"测试 ♡€ ☺"}
        };
    }

    @DataProvider(name = "twoFieldsTest")
    public static Object[][] createDataForTwoFields() {
        return new Object[][]{
                {0, 0},
                {0, new Random().nextInt(100)},
                {new Random().nextInt(-1+100)-100, 0},
                {new Random().nextInt(100), new Random().nextInt(100)},
                {new Random().nextInt(-1+100)-100, new Random().nextInt(-1+100)-100},
                {new Random().nextInt(100), new Random().nextInt(-1+100)-100}
        };
    }

    @DataProvider(name = "twoFieldsTestNegative")
    public static Object[][] createDataForTwoFieldsNegative() {
        return new Object[][]{
                { "someString", "otherString" },
                { " ", " " },
                { "~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?", "测试 ♡€ ☺" },
                { String.valueOf(new Random().nextInt(100)), "SomeString" },
                { "SomeString", String.valueOf(new Random().nextInt(-1+100)-100) }
        };
    }

}

package seleniumEasyTests.InputFormTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class InputFormDataProvider {

    @DataProvider(name = "formAllFieldValidTest")
    public static Object[][] createDataPositiveForm() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(10),  //firstName
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
        };
    }

    @DataProvider(name = "firsLastNamesTestPositive")
    public static Object[][] createDataPositiveFirstLastName() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(2)},
                {RandomStringUtils.randomAlphabetic(10)},
                {RandomStringUtils.randomNumeric(2)},
                {"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?"},
                {"测试 ♡€ ☺"}

        };
    }

    @DataProvider(name = "firsLastNamesTestNegative")
    public static Object[][] createDataNegativeFirstLastName() {
        return new Object[][]{

                {" "},
                {RandomStringUtils.randomAlphabetic(1)},
                {RandomStringUtils.randomNumeric(1)},
                {RandomStringUtils.randomAscii(1)},

        };
    }

    @DataProvider(name = "emailTestPositive")
    public static Object[][] createDataPositiveEmail() {
        return new Object[][]{

                //minimum length
                {RandomStringUtils.randomAlphabetic(1) + "@" + RandomStringUtils.randomAlphabetic(1).toLowerCase() + "." + RandomStringUtils.randomAlphabetic(2).toLowerCase()},

                //maximum length (if we assume that max is 254)
                {RandomStringUtils.randomAlphabetic(2) + "@" + RandomStringUtils.randomAlphabetic(248) + "." + RandomStringUtils.randomAlphabetic(2)},

                //all in lower case
                {RandomStringUtils.randomAlphabetic(7).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(5).toLowerCase() + "." + RandomStringUtils.randomAlphabetic(3).toLowerCase()},

                //all in upper case
                {RandomStringUtils.randomAlphabetic(7).toUpperCase() + "@" + RandomStringUtils.randomAlphabetic(5).toUpperCase() + "." + RandomStringUtils.randomAlphabetic(2).toUpperCase()},

                //all with the numeric
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(2)},

                //with "-" in the name part
                {RandomStringUtils.randomAlphanumeric(7) + "-@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(2)},

                //with "-" in the domain part
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(2) + "-" + RandomStringUtils.randomAlphanumeric(3) + "." + RandomStringUtils.randomAlphanumeric(2)},

                //with "_" in the name part
                {RandomStringUtils.randomAlphanumeric(7) + "_@" + RandomStringUtils.randomAlphanumeric(2) + RandomStringUtils.randomAlphanumeric(3) + "." + RandomStringUtils.randomAlphanumeric(3)},

                // "." in the name part
                {RandomStringUtils.randomAlphanumeric(4) + "." + RandomStringUtils.randomAlphanumeric(3) + "@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(2)},

                // "." in the domain part
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(2) + "." + RandomStringUtils.randomAlphanumeric(3) + "." + RandomStringUtils.randomAlphanumeric(3)},

                // five symbols in first level domain part
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(5)}

        };
    }

    @DataProvider(name = "emailTestNegative")
    public static Object[][] createDataNegativeEmail() {
        return new Object[][]{

                //empty field
                {" "},

                //text with "_" within the domain , strange that is not valid for the form
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(2) + "_" + RandomStringUtils.randomAlphanumeric(3) + "." + RandomStringUtils.randomAlphanumeric(2)},

                //text with "." before domain of 1 level
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5) + ".." + RandomStringUtils.randomAlphanumeric(2)},

                //without dots in the end of the domain
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(2) + "_" + RandomStringUtils.randomAlphanumeric(3) + RandomStringUtils.randomAlphanumeric(2)},

                //without "@"
                {RandomStringUtils.randomAlphanumeric(7) + RandomStringUtils.randomAlphanumeric(2) + "_" + RandomStringUtils.randomAlphanumeric(3) + "." + RandomStringUtils.randomAlphanumeric(2)},

                // more than 254 symbols
                {RandomStringUtils.randomAlphanumeric(64) + "@" + RandomStringUtils.randomAlphanumeric(187) + "." + RandomStringUtils.randomAlphanumeric(2)},

                //space in the name part
                {RandomStringUtils.randomAlphanumeric(7) + " @" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(4)},

                //space in the domain part
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5) + " ." + RandomStringUtils.randomAlphanumeric(2)},

                //without name part
                {"@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(3)},

                //without domain part
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(3)},

                //1 symbol in the 1 level domain
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(1)},

                //more than 6 symbols in the 1 level domain
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5) + "." + RandomStringUtils.randomAlphanumeric(7)},

                //without 1 level domain part
                {RandomStringUtils.randomAlphanumeric(7) + "@" + RandomStringUtils.randomAlphanumeric(5)},

        };

    }

    @DataProvider(name = "phoneTestPositive")
    public static Object[][] createDataPhone() {
        final String validRandomNumber = "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4);
        return new Object[][]{

                //10 numbers (despite the placeholder shows format with ")" just numbers are applicable as well for the form
                {RandomStringUtils.randomNumeric(10)},

                //10 with "(" and ")"
                {validRandomNumber},

                //placeholder
                {"(845)555-1212"},

                //10 symbols with backspaces
                {RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(4)},

                //10 symbols with "-"
                {RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4)},

                //random number + backspace
                {validRandomNumber + "  "},

                //backspace + random number
                {"  " + validRandomNumber}

        };
    }

    @DataProvider(name = "phoneTestNegative")
    public static Object[][] createDataPhoneNegative() {
        final String validRandomNumber = "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4);
        return new Object[][]{

                {" "},

                //less than 10 numbers (9)
                {"(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3)},

                //more than 10 numbers (11)
                {"(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(5)},

                //letters instead of numbers
                {"(" + RandomStringUtils.randomAlphabetic(3) +")" + RandomStringUtils.randomAlphabetic(3) + "-" + RandomStringUtils.randomAlphabetic(4)},

                //9 numbers + 1 symbol
                {"(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3) + RandomStringUtils.randomAlphabetic(1)},

                //1 number + 9 symbols
                {RandomStringUtils.randomAlphabetic(1) + "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3)},

                //numbers + ascii symbols
                {"(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomAscii(3) + "-" + RandomStringUtils.randomNumeric(2) + RandomStringUtils.randomAscii(2)},

        };
    }

}

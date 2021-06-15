package seleniumEasyTests.InputFormTests;

import AutoUni.helper.CommonHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class InputFormDataProvider {

    @DataProvider(name = "formAllFieldValidTest")
    public static Object[][] createDataPositiveForm() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(10),  //firstName
                        RandomStringUtils.randomAlphabetic(10),  //lastName
                        RandomStringUtils.randomAlphabetic(5) + "@test.com", //email
                        "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4), //phoneNumber
                        "475 Lenfant plz sw RM", //address
                        RandomStringUtils.randomAlphabetic(5), //city
                        RandomStringUtils.randomNumeric(5), //ZIP-code
                        RandomStringUtils.randomAlphanumeric(5), //domain
                        CommonHelper.createDescriptionText(3) //description

                },
        };
    }

    @DataProvider(name = "formAllFieldInValidTest")
    public static Object[][] createDataNegativeForm() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(1),  //firstName
                 RandomStringUtils.randomAlphabetic(2),  //lastName
                 RandomStringUtils.randomAlphabetic(5) + " @test.com", //email
                 "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3), //phoneNumber
                 RandomStringUtils.randomAlphanumeric(7), //address
                 RandomStringUtils.randomAlphabetic(3), //city
                 RandomStringUtils.randomNumeric(10), //ZIP-code
                 " ", //domain
                 " " //description
                },
        };
    }

    @DataProvider(name = "formOneFieldInValidTest")
    public static Object[][] createDataOneInvalidForm() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(10),  //firstName
                RandomStringUtils.randomAlphabetic(10),  //lastName
                RandomStringUtils.randomAlphabetic(5) + "@test.com", //email
                "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4), //phoneNumber
                "475 Lenfant plz sw RM", //address
                RandomStringUtils.randomAlphabetic(5), //city
                RandomStringUtils.randomNumeric(10), //ZIP-code
                RandomStringUtils.randomAlphanumeric(5), //domain
                CommonHelper.createDescriptionText(3) //description
                },
        };
    }

    @DataProvider(name = "formOneFieldValidTest")
    public static Object[][] createDataOneValidForm() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(10),  //firstName
                 RandomStringUtils.randomAlphabetic(2),  //lastName
                 RandomStringUtils.randomAlphabetic(5) + " @test.com", //email
                 "(" + RandomStringUtils.randomNumeric(3) +")" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3), //phoneNumber
                 RandomStringUtils.randomAlphanumeric(7), //address
                 RandomStringUtils.randomAlphabetic(3), //city
                 RandomStringUtils.randomNumeric(10), //ZIP-code
                 " ", //domain
                 " " //description
                },
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

    @DataProvider(name = "addressTestPositive")
    public static Object[][] createDataAddress() {
        final String randomAddress = RandomStringUtils.randomNumeric(4) + RandomStringUtils.randomAlphabetic(7) + RandomStringUtils.randomAlphabetic(3);
        return new Object[][]{

                //8 symbols
                {RandomStringUtils.randomAlphanumeric(8)},

                //8 numbers
                {RandomStringUtils.randomNumeric(8)},

                {"address"},

                //very long text
                {RandomStringUtils.randomAlphanumeric(255)},

                {randomAddress},

                //USA address (not random)
                {"475 Lenfant plz sw RM"},

                //with Unicode characters
                {"475 Lenfant☺ plz sw RM 测试"},

                //address + symbols
                {randomAddress + "~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?"}

        };
    }

    @DataProvider(name = "addressTestNegative")
    public static Object[][] createDataAddressNegative() {
        return new Object[][]{

                {" "},
                {RandomStringUtils.randomAlphanumeric(7)},

        };
    }

    @DataProvider(name = "cityTestPositive")
    public static Object[][] createDataCity() {
        return new Object[][]{

                //4 symbols
                {RandomStringUtils.randomAlphabetic(4)},

                //5 symbols
                {RandomStringUtils.randomAlphabetic(5)},

                //255 letters
                {RandomStringUtils.randomAlphabetic(255)},

                //placeholder
                {"city"},

                //with space
                {RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(3)},

                //with 3 words
                {RandomStringUtils.randomAlphabetic(4) + " " + RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(5)},

                ///with "-"
                {RandomStringUtils.randomAlphabetic(4) + "-" + RandomStringUtils.randomAlphabetic(3) + "-" + RandomStringUtils.randomAlphabetic(5)},

                //with Unicode symbols
                {RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.random(3 ,"测试 ♡€ ☺")},

                //with special chars
                {RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.random(3 ,"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?")}

        };
    }

    @DataProvider(name = "cityTestNegative")
    public static Object[][] createDataCityNegative() {
        return new Object[][]{

                {" "},
                {RandomStringUtils.randomAlphabetic(3)},
                {RandomStringUtils.randomNumeric(3)},

        };
    }

    @DataProvider(name = "zipTestPositive")
    public static Object[][] createDataZip() {
        return new Object[][]{

                {RandomStringUtils.randomNumeric(4)},
                {RandomStringUtils.randomNumeric(5)},
                {RandomStringUtils.randomNumeric(5) + "-" + RandomStringUtils.randomNumeric(4)},
                {RandomStringUtils.randomNumeric(8)},
                {RandomStringUtils.randomNumeric(9)}

        };
    }

    @DataProvider(name = "zipTestNegative")
    public static Object[][] createDataZipNegative() {
        return new Object[][]{

                {" "},
                {" " + RandomStringUtils.randomNumeric(4)},
                {RandomStringUtils.randomNumeric(5) + "  " + RandomStringUtils.randomNumeric(3)},
                {RandomStringUtils.randomNumeric(8) + " "},
                {RandomStringUtils.randomNumeric(3)},
                {RandomStringUtils.randomNumeric(6)},
                {RandomStringUtils.randomNumeric(10)},
                {RandomStringUtils.randomAlphabetic(4)},
                {RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomAlphabetic(4)},
                {RandomStringUtils.randomNumeric(4) + "-" + RandomStringUtils.randomNumeric(5)},
                { "-" + RandomStringUtils.randomNumeric(4) + RandomStringUtils.randomNumeric(4)},
                {RandomStringUtils.randomNumeric(5) + RandomStringUtils.random(1 ,"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?") + RandomStringUtils.randomNumeric(4)},
                {RandomStringUtils.randomNumeric(5) + RandomStringUtils.random(1 ,"测试 ♡€ ☺") + RandomStringUtils.randomNumeric(4)},
                {RandomStringUtils.randomNumeric(5) + " " + RandomStringUtils.randomNumeric(4)},
        };
    }

    @DataProvider(name = "websiteFieldTest")
    public static Object[][] createDataWebsite() {
        return new Object[][]{

                {" "},
                {RandomStringUtils.randomAlphanumeric(10).toUpperCase()},
                {RandomStringUtils.randomAlphanumeric(10)},
                {RandomStringUtils.random(6,"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?")},
                {RandomStringUtils.random(4 ,"测试 ♡€ ☺")},
                {RandomStringUtils.randomAlphanumeric(7) + "." + RandomStringUtils.randomAlphanumeric(3)},
                {RandomStringUtils.randomAlphanumeric(255)}

        };
    }

    @DataProvider(name = "descriptionFieldTest")
    public static Object[][] createDataDescription() {
        return new Object[][]{

                {" "},
                {CommonHelper.createDescriptionText(1)},
                {CommonHelper.createDescriptionText(10)},
                {CommonHelper.createDescriptionText(5) + RandomStringUtils.random(6,"~`!@#$%^&*()’-_+=|\\[]{}\":;'<>,./?") + RandomStringUtils.random(4 ,"测试 ♡€ ☺")},
                {CommonHelper.createDescriptionText(255)}

        };
    }

}

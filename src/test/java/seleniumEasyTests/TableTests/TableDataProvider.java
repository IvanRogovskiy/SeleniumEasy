package seleniumEasyTests.TableTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class TableDataProvider {

    @DataProvider(name = "TableSearchTestPositive")
    public static Object[][] createTableDataSearchPositive() {
        return new Object[][]{

                {"R"},
                {"Reg"},
                {"Region"},
                {"ional"},
                {"Regional"},
                {"REGIONAL"},
                {"Regional "},
                {"Regional Lo"},
        };
    }
}

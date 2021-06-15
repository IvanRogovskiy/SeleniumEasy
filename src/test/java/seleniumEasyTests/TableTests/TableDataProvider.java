package seleniumEasyTests.TableTests;

import AutoUni.data.SortingOrder;
import AutoUni.data.TableColumn;
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
                {"Regional Lo 19"},
                {"Regional Director 385"},
                {"Jun"},
                {"Jun 11"},
                {"0/y"}

        };
    }

    @DataProvider(name = "TableSearchTestNegative")
    public static Object[][] createTableDataSearchNegative() {
        return new Object[][]{

                {"Ramos j"},
                {"Wagner 3"},
                {"acc Dec"},
                {"Yberry"},
                {"cox@"},
                {"313.500"},
                {"Wi 100"}
        };
    }

    @DataProvider(name = "TableFilterTest")
    public static Object[][] filterData() {
        return new Object[][]{

                {"Reg", TableColumn.NAME, SortingOrder.DESC},
                {"Reg", TableColumn.NAME, SortingOrder.ASC},
                {"Reg", TableColumn.OFFICE, SortingOrder.DESC},
                {"Reg", TableColumn.OFFICE, SortingOrder.ASC},
                {"Av", TableColumn.POSITION, SortingOrder.ASC},
                {"Av", TableColumn.POSITION, SortingOrder.DESC}
        };
    }

}

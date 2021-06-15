package seleniumEasyTests.TableTests;

import AutoUni.DriverInit;
import AutoUni.data.SortingOrder;
import AutoUni.data.TableColumn;
import AutoUni.helper.TableHelper;
import AutoUni.pages.seleniumEasy.TablePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TableTest extends DriverInit {

    @Test(groups = {"TableTest"}, dataProvider = "TableSearchTestPositive", dataProviderClass = TableDataProvider.class)
    public void positiveSearchTest(String value) {
        TablePage tablePage = new TablePage(driver);
        tablePage.open(baseUrl).isOpened();
        List<WebElement> listOfEntries = tablePage.searchItems(value).getFoundElements();
        Assert.assertTrue(tablePage.areSearchResultsValid(listOfEntries));
    }

    @Test(groups = {"TableTest"}, dataProvider = "TableSearchTestNegative", dataProviderClass = TableDataProvider.class)
    public void negativeSearchTest(String value) {
        TablePage tablePage = new TablePage(driver);
        tablePage.open(baseUrl).isOpened();
        List<WebElement> listOfEntries = tablePage.searchItems(value).getFoundElements();
        Assert.assertFalse(tablePage.areSearchResultsValid(listOfEntries));
    }

    @Test(groups = {"TableTest"}, dataProvider = "TableFilterTest", dataProviderClass = TableDataProvider.class)
    public void filterByNameTest(String query, TableColumn tableColumn, SortingOrder sortingOrder) {
        TablePage tablePage = new TablePage(driver);
        tablePage.open(baseUrl).isOpened();

        List <WebElement> elementsBeforeSorting = tablePage.searchItems(query).getFoundElements();
        List<Map<String, String>> entriesValuesBeforeSorting = TableHelper.fromWebElementsToListOfEntriesMaps(elementsBeforeSorting);
        List<String> listOfNamesBeforeSorting = TableHelper.getColumnValuesAsList(entriesValuesBeforeSorting, tableColumn);

        if (sortingOrder == SortingOrder.DESC) {
            listOfNamesBeforeSorting.sort(Collections.reverseOrder());
        } else Collections.sort(listOfNamesBeforeSorting);

        tablePage.filterBy(tableColumn, sortingOrder);
        List<Map<String, String>> entriesValuesAfterSorting = TableHelper.fromWebElementsToListOfEntriesMaps(tablePage.searchItems(query).getFoundElements());
        List<String> listOfNamesAfterSorting = TableHelper.getColumnValuesAsList(entriesValuesAfterSorting, tableColumn);

        Assert.assertEquals(listOfNamesBeforeSorting, listOfNamesAfterSorting);
    }

}

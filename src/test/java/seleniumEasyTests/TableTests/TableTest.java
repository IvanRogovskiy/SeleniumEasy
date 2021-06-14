package seleniumEasyTests.TableTests;

import AutoUni.DriverInit;
import AutoUni.pages.seleniumEasy.TablePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumEasyTests.InputFormTests.InputFormDataProvider;

import java.util.List;


public class TableTest extends DriverInit {

    @Test(groups = {"TableTest"}, dataProvider = "TableSearchTestPositive", dataProviderClass = TableDataProvider.class)
    public void positiveSearchTest(String value) {
        TablePage tablePage = new TablePage(driver);
        tablePage.open(baseUrl);
        List<WebElement> listOfEntries = tablePage.isOpened().searchItems(value).getFoundElements();
        Assert.assertTrue(tablePage.areSearchResultsValid(listOfEntries));
    }

}

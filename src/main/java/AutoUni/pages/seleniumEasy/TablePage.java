package AutoUni.pages.seleniumEasy;

import AutoUni.helper.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class TablePage extends BasePage {

    private final By searchFieldLocator = By.cssSelector("#example_filter [type='search']"),
    foundItemsLocator = By.xpath("//table//tr[contains(@role, 'row')]");


    public TablePage(WebDriver driver) {
        super(driver, "/table-sort-search-demo.html");
    }

    public TablePage isOpened() {
        Assert.assertTrue(new CommonHelper(driver).isPageLoaded());
        return this;
    }

    public TablePage searchItems(String query) {
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.clear();
        searchField.sendKeys(query);
        return this;
    }

    public List<WebElement> getFoundElements() {
       webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(foundItemsLocator));
       List<WebElement> items = driver.findElements(foundItemsLocator);
       return items.stream()
               .filter(item -> !item.getText().contains("Name"))
               .collect(Collectors.toList());
    }

    public boolean areSearchResultsValid(List<WebElement> listOfFoundElements) {
        if (listOfFoundElements.isEmpty()) {
            return false;
        }
        AtomicBoolean result = new AtomicBoolean(true);
        listOfFoundElements.forEach(element -> {
            if (!element.getText().contains(driver.findElement(searchFieldLocator).getText())) {
                result.set(false);
            }
        });
        return result.get();
    }

}

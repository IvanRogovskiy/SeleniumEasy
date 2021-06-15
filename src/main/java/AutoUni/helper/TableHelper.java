package AutoUni.helper;

import AutoUni.data.TableColumn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TableHelper {


    public static List<Map<String, String>> fromWebElementsToListOfEntriesMaps(List<WebElement> entries) {
        return entries.stream()
                .map(TableHelper::convertFromWebElementToMap)
                .collect(Collectors.toList());
    }

    public static Map<String, String> convertFromWebElementToMap(WebElement tableEntry) {
        Map<String, String> entry = new HashMap<>();
        List<WebElement> values = tableEntry.findElements(By.tagName("td"));
        for (int i = 0; i < values.size(); i++) {
            switch (i) {
                case 0:
                    entry.put(TableColumn.NAME.getColumnTitle(), values.get(i).getText());
                    break;
                case 1:
                    entry.put(TableColumn.POSITION.getColumnTitle(), values.get(i).getText());
                    break;
                case 2:
                    entry.put(TableColumn.OFFICE.getColumnTitle(), values.get(i).getText());
                    break;
                case 3:
                    entry.put(TableColumn.AGE.getColumnTitle(), values.get(i).getText());
                    break;
                case 4:
                    entry.put(TableColumn.START_DATE.getColumnTitle(), values.get(i).getText());
                    break;
                case 5:
                    entry.put(TableColumn.SALARY.getColumnTitle(), values.get(i).getText());
                    break;
                default:
                    throw new IndexOutOfBoundsException();
            }
        }
        return entry;
    }

    public static List<String> getColumnValuesAsList(List<Map<String, String>> entries, TableColumn tableColumn) {
        return entries.stream()
                .map(entry -> entry.get(tableColumn.getColumnTitle()))
                .collect(Collectors.toList());
    }
}
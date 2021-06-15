package AutoUni.data;

public enum TableColumn {

    NAME ("Name"),
    POSITION ("Position"),
    OFFICE ("Office"),
    AGE ("Age"),
    START_DATE ("Start date"),
    SALARY ("Salary");

    final String columnTitle;

    TableColumn(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getColumnTitle() {
        return columnTitle;
    }
}

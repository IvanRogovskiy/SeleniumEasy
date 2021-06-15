package AutoUni.data;

public enum SortingOrder {

    ASC ("ascending"),
    DESC ("descending");

    final String attrValue;

    SortingOrder(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getAttrValue() {
        return attrValue;
    }

}

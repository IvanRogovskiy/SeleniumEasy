package AutoUni.data;

public enum InputFormFieldName {

    FIRST_NAME ("first_name"),
    LAST_NAME ("last_name"),
    E_MAIL ("email"),
    PHONE ("phone"),
    ADDRESS ("address"),
    CITY ("city"),
    ZIP_CODE ("zip"),
    DOMAIN ("website"),
    DESCRIPTION ("description");

    final String fieldName;

    InputFormFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

}

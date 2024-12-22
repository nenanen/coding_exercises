package exercise2.main.office;

public interface Spreadsheet {

    String get(int row, int column) throws IndexOutOfBoundsException;

    ValueType getValueType(int row, int column) throws IndexOutOfBoundsException;

    void put(int row, int column, String value) throws IndexOutOfBoundsException;
}

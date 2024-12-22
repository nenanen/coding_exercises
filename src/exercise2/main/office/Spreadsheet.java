package exercise2.main.office;

public interface Spreadsheet {

    String get(int row, int column);

    void put(int row, int column, String value);
}

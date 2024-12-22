package exercise2.main.office;

import static exercise2.main.utils.StringUtils.isInteger;

public class SpreadSheetImpl implements Spreadsheet {
    private final String[][] spreadSheet;

    public SpreadSheetImpl(int rows, int columns) {
        spreadSheet = generateEmptySpreadSheet(rows, columns);
    }

    @Override
    public String get(int row, int column) throws IndexOutOfBoundsException {
        return spreadSheet[row][column];
    }

    @Override
    public ValueType getValueType(int row, int column) throws IndexOutOfBoundsException {
        String value = get(row, column);
        return ValueType.ofString(value);
    }

    @Override
    public void put(int row, int column, String value) throws IndexOutOfBoundsException {
        spreadSheet[row][column] = cleanValue(value);
    }

    /**
     * Cleans the provided spreadsheet value.
     * Specifically, by trimming whitespaces from integer values.
     * Other types of values are returned without any changes.
     *
     * @param value the Spreadsheet value to check and clean
     * @return the cleaned value, safe to store in the spreadsheet
     */
    private String cleanValue(String value) {
        if (ValueType.ofString(value.trim()) == ValueType.INTEGER) {
            return value.trim();
        }
        return value;
    }

    private String[][] generateEmptySpreadSheet(int rows, int columns) {
        String[][] emptySpreadSheet = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                emptySpreadSheet[i][j] = "";
            }
        }
        return emptySpreadSheet;
    }
}

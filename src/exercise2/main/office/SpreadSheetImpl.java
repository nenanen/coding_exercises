package exercise2.main.office;


public class SpreadSheetImpl implements Spreadsheet {
    private final String[][] spreadSheet;
    private final int rowsCount;
    private final int columnsCount;

    public SpreadSheetImpl(int rows, int columns) {
        this.spreadSheet = generateEmptySpreadSheet(rows, columns);
        this.rowsCount = rows;
        this.columnsCount = columns;
    }

    @Override
    public String get(int row, int column) throws IndexOutOfBoundsException {
        String value = spreadSheet[row][column];
        return value != null ? value : "";
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

    @Override
    public String[][] getSheet() {
        return spreadSheet;
    }


    @Override
    public int getRowsCount() {
        return rowsCount;
    }


    @Override
    public int getColumnsCount() {
        return columnsCount;
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

package exercise2.main.office;


import exercise2.main.office.exceptions.InvalidSpreadSheetDimensionsException;

public class SpreadSheetImpl implements Spreadsheet {
    private final String[][] spreadSheet;
    private final int rowsCount;
    private final int columnsCount;


    /**
     * Constructs a SpreadSheetImpl instance with the specified number of rows and columns.
     * The spreadsheet is initialized with empty string values: "".
     *
     * @param rows    the number of rows in the spreadsheet. Must be at least 0.
     * @param columns the number of columns in the spreadsheet. Must be at least 0.
     */
    public SpreadSheetImpl(int rows, int columns) throws InvalidSpreadSheetDimensionsException {
        if (rows < 0) {
            throw new InvalidSpreadSheetDimensionsException("SpreadSheet rows count cannot be negative");
        } else if (columns < 0) {
            throw new InvalidSpreadSheetDimensionsException("SpreadSheet column count cannot be negative");
        }

        this.spreadSheet = generateEmptySpreadSheet(rows, columns);

        this.rowsCount = rows;
        this.columnsCount = columns;
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

    /**
     * Generates an empty spreadsheet with the specified dimensions.
     * All cells are initialized to an empty string.
     *
     * @param rows    the number of rows in the spreadsheet.
     * @param columns the number of columns in the spreadsheet.
     * @return a 2D array representing an empty spreadsheet.
     */
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

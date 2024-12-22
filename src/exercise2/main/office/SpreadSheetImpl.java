package exercise2.main.office;

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
    public void put(int row, int column, String value) {
        spreadSheet[row][column] = value;
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

package exercise2.main.office;

public class Office {

    public static SpreadSheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadSheetImpl(rows, columns);
    }
}

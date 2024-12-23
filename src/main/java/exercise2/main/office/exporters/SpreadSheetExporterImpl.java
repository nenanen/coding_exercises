package exercise2.main.office.exporters;

import exercise2.main.office.SpreadSheetImpl;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpreadSheetExporterImpl implements SpreadSheetExporter {
    private final SpreadSheetImpl spreadSheet;
    private final String delimiter;

    public SpreadSheetExporterImpl(SpreadSheetImpl spreadSheet, String delimiter) {
        this.spreadSheet = spreadSheet;
        this.delimiter = delimiter;
    }

    /**
     * Exports the spreadsheet data as a string.
     * <p>
     * This method concatenates the export header and body into a single string.
     * The header contains the dimensions of the spreadsheet (rows and columns).
     * The body contains the actual data from the spreadsheet, formatted with a delimiter value.
     *
     * @return a string representation of the exported spreadsheet,
     * consisting of the header followed by the body.
     */
    @Override
    public String export() {
        return getExportHeader() + getExportBody();
    }

    /**
     * Creates the header section of the exported spreadsheet.
     *
     * @return a string representing the spreadsheet header in the format "rows,columns#".
     */
    private String getExportHeader() {
        return String.format("%d,%d#", spreadSheet.getRowsCount(), spreadSheet.getColumnsCount());
    }

    /**
     * Generates the body section of the exported spreadsheet.
     * The body contains the spreadsheet data, with values separated by the specified delimiter.
     *
     * @return a string representing the spreadsheet body.
     */
    private String getExportBody() {
        return Arrays.stream(spreadSheet.getSheet())
                .flatMap(Arrays::stream
                )
                .collect(Collectors.joining(delimiter)) + delimiter; // Use the delimiter for separating values. Plus appending a final delimiter
    }

}

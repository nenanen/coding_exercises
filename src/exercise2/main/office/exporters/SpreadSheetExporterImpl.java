package exercise2.main.office.exporters;

import exercise2.main.office.SpreadSheetImpl;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpreadSheetExporterImpl implements SpreadSheetExporter {
    private final SpreadSheetImpl spreadSheet;
    private final String delimiter;

    SpreadSheetExporterImpl(SpreadSheetImpl spreadSheet, String delimiter) {
        this.spreadSheet = spreadSheet;
        this.delimiter = delimiter;
    }


    /**
     * Exports the spreadsheet data as a string.
     * <p>
     * This method concatenates the export header and body into a single string.
     * The header contains the dimensions of the spreadsheet (rows and columns),
     * and the body contains the actual data from the spreadsheet,
     * formatted with a delimiter value.
     *
     * @return a string representation of the exported spreadsheet,
     * consisting of the header followed by the body.
     */
    @Override
    public String export() {
        return getExportHeader() + getExportBody();
    }

    private String getExportHeader() {
        return String.format("%d,%d#", spreadSheet.getRowsCount(), spreadSheet.getColumnsCount());
    }

    private String getExportBody() {
        return Arrays.stream(spreadSheet.getSheet())
                .flatMap(list ->
                        Arrays.stream(list)
                                .map(value -> value != null ? value : "")
                )
                .collect(Collectors.joining(delimiter)) + delimiter;
    }

}

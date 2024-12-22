package exercise2.main.office.exporters;

import exercise2.main.office.SpreadSheetImpl;

public class StarSpreadSheetExporter extends SpreadSheetExporterImpl {

    public StarSpreadSheetExporter(SpreadSheetImpl sheet) {
        super(sheet, "*");
    }
}

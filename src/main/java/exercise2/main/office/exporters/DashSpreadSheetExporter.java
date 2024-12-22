package exercise2.main.office.exporters;

import exercise2.main.office.SpreadSheetImpl;

public class DashSpreadSheetExporter extends SpreadSheetExporterImpl {

    public DashSpreadSheetExporter(SpreadSheetImpl sheet) {
        super(sheet, "-");
    }
}

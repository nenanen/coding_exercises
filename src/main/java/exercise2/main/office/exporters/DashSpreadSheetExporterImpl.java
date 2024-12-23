package exercise2.main.office.exporters;

import exercise2.main.office.SpreadSheetImpl;

public class DashSpreadSheetExporterImpl extends SpreadSheetExporterImpl {

    public DashSpreadSheetExporterImpl(SpreadSheetImpl sheet) {
        super(sheet, "-");
    }
}

package exercise2.main.office.exporters;

import exercise2.main.office.SpreadSheetImpl;

public class StarSpreadSheetExporterImpl extends SpreadSheetExporterImpl {

    public StarSpreadSheetExporterImpl(SpreadSheetImpl sheet) {
        super(sheet, "*");
    }
}

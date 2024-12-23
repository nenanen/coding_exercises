package exercise2.tests.office.exporters;

import exercise2.main.office.SpreadSheetImpl;
import exercise2.main.office.exporters.SpreadSheetExporterImpl;
import exercise2.main.office.exporters.StarSpreadSheetExporterImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StarSpreadSheetExporterImplImplTest {

    @Test
    public void exportsSpreadsheetWithStars() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        sheet.put(0, 0, "A");
        sheet.put(0, 1, "B");
        sheet.put(1, 0, "C");
        sheet.put(1, 1, "D");
        SpreadSheetExporterImpl exporter = new StarSpreadSheetExporterImpl(sheet);

        String actual = exporter.export();
        String expected = "2,2#A*B*C*D*";
        Assert.assertEquals(expected, actual);
    }
}

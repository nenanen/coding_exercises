package exercise2.tests.office.exporters;

import exercise2.main.office.SpreadSheetImpl;
import exercise2.main.office.exporters.SpreadSheetExporterImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpreadSheetExporterImplTest {

    @Test
    public void exportsSpreadSheetWithoutRowsAndColumns() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(0, 0);
        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, ",");

        String actual = exporter.export();
        String expected = "0,0#,";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void exportsEmptySpreadSheet() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, ",");

        String actual = exporter.export();
        String expected = "2,2#,,,,";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exportsSpreadSheetWithEmptyDelimiter() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        sheet.put(0, 0, "A");
        sheet.put(0, 1, "B");
        sheet.put(1, 0, "C");
        sheet.put(1, 1, "D");
        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, "");

        String actual = exporter.export();
        String expected = "2,2#ABCD";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exportsWithSingleDelimiterComma() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(1, 3);
        sheet.put(0, 0, "A");
        sheet.put(0, 1, "B");
        sheet.put(0, 2, "C");

        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, ",");

        String actual = exporter.export();
        String expected = "1,3#A,B,C,";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void exportsWithSingleDelimiterHashtag() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(1, 3);
        sheet.put(0, 0, "A");
        sheet.put(0, 1, "B");
        sheet.put(0, 2, "C");

        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, "#");

        String actual = exporter.export();
        String expected = "1,3#A#B#C#";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void exportsEmptySpreadSheetWithMultiCharDelimiter() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, "->");

        String actual = exporter.export();
        String expected = "2,2#->->->->";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exportsWhenSomeValuesNotSet() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        sheet.put(0, 0, "X");
        sheet.put(1, 1, "Y");

        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, ",");

        String actual = exporter.export();
        String expected = "2,2#X,,,Y,";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exportsMixedValuesTypes() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        sheet.put(0, 0, "42");
        sheet.put(0, 1, "=formula");
        sheet.put(1, 0, "string");
        sheet.put(1, 1, "");

        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, ",");

        String actual = exporter.export();
        String expected = "2,2#42,=formula,string,,";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exportsSingleRowSpreadSheet() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(1, 4);
        sheet.put(0, 0, "A");
        sheet.put(0, 1, "B");
        sheet.put(0, 2, "C");
        sheet.put(0, 3, "D");

        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, ",");

        String actual = exporter.export();
        String expected = "1,4#A,B,C,D,";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exportsSingleColumnSpreadSheet() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(4, 1);
        sheet.put(0, 0, "1");
        sheet.put(1, 0, "2");
        sheet.put(2, 0, "3");
        sheet.put(3, 0, "4");

        SpreadSheetExporterImpl exporter = new SpreadSheetExporterImpl(sheet, "-");

        String actual = exporter.export();
        String expected = "4,1#1-2-3-4-";
        Assert.assertEquals(expected, actual);
    }
}

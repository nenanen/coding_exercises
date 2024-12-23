package exercise2.tests;

import exercise2.main.office.SpreadSheetImpl;
import exercise2.main.office.ValueType;
import exercise2.main.office.exceptions.InvalidSpreadSheetDimensionsException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpreadSheetImplTest {

    @Test
    public void initializesWithEmptyValues() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(3, 3);

        Assert.assertEquals(3, sheet.getRowsCount());
        Assert.assertEquals(3, sheet.getColumnsCount());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Assert.assertEquals("", sheet.get(i, j));
            }
        }
    }

    @Test
    public void handlesPutAndGetValues() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);

        sheet.put(0, 0, "Hello");
        sheet.put(1, 1, "World");

        Assert.assertEquals("Hello", sheet.get(0, 0));
        Assert.assertEquals("World", sheet.get(1, 1));
        Assert.assertEquals("", sheet.get(0, 1)); // Cell not updated
    }

    @Test
    public void trimsIntegerValuesOnPut() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(1, 1);

        sheet.put(0, 0, " 42 ");

        Assert.assertEquals("42", sheet.get(0, 0));
    }

    @Test
    public void doesNotTrimNonIntegerValuesOnPut() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(1, 1);

        sheet.put(0, 0, "  Hello  ");

        Assert.assertEquals("  Hello  ", sheet.get(0, 0));


        sheet.put(0, 0, "= some formula   ");

        Assert.assertEquals("= some formula   ", sheet.get(0, 0));
    }

    @Test
    public void identifiesValueTypeCorrectly() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);

        sheet.put(0, 0, "42");
        sheet.put(0, 1, "= 1 + 1");
        sheet.put(1, 0, "Hello");

        Assert.assertEquals(ValueType.INTEGER, sheet.getValueType(0, 0));
        Assert.assertEquals(ValueType.FORMULA, sheet.getValueType(0, 1));
        Assert.assertEquals(ValueType.STRING, sheet.getValueType(1, 0));
    }

    @Test
    public void handlesEmptyCellsAsStringType() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);

        Assert.assertEquals(ValueType.STRING, sheet.getValueType(0, 0));
        Assert.assertEquals(ValueType.STRING, sheet.getValueType(1, 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwsExceptionOnGetOutOfBounds() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        sheet.get(3, 0); // Out of bounds row
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwsExceptionOnPutOutOfBounds() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);
        sheet.put(0, 3, "OutOfBounds"); // Out of bounds column
    }

    @Test
    public void handlesGetSheet() {
        SpreadSheetImpl sheet = new SpreadSheetImpl(2, 2);

        sheet.put(0, 0, "a ");
        sheet.put(0, 1, "= 1*10 ");
        sheet.put(1, 0, "  10  ");
        sheet.put(1, 1, "  Hello ");

        String[][] actual = sheet.getSheet();
        Assert.assertArrayEquals(new String[][]{{"a ", "= 1*10 "}, {"10", "  Hello "}}, actual);
    }

    @Test(expected = InvalidSpreadSheetDimensionsException.class)
    public void throwsExceptionForNegativeRows() {
        new SpreadSheetImpl(-1, 0);
    }


    @Test(expected = InvalidSpreadSheetDimensionsException.class)
    public void throwsExceptionForNegativeColumns() {
        new SpreadSheetImpl(10, -2);
    }
}

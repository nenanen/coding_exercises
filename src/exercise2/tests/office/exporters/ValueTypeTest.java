package exercise2.tests.office.exporters;

import exercise2.main.office.ValueType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ValueTypeTest {

    @Test
    public void recognizesIntegers() {
        Assert.assertEquals(ValueType.INTEGER, ValueType.ofString("-1"));
        Assert.assertEquals(ValueType.INTEGER, ValueType.ofString("999"));
    }

    @Test
    public void recognizesFormulas() {
        Assert.assertEquals(ValueType.FORMULA, ValueType.ofString("=1+2"));
        Assert.assertEquals(ValueType.FORMULA, ValueType.ofString("=    1 % 5"));
    }


    @Test
    public void recognizesStrings() {
        Assert.assertEquals(ValueType.STRING, ValueType.ofString(""));
        Assert.assertEquals(ValueType.STRING, ValueType.ofString("'123"));
        Assert.assertEquals(ValueType.STRING, ValueType.ofString("' = 123'"));
        Assert.assertEquals(ValueType.STRING, ValueType.ofString("hello"));
    }
}


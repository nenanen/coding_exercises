package exercise2.tests.utils;

import exercise2.main.utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class StringUtilsTest {

    @Test
    public void isIntegerReturnsTrueForPositiveInteger() {
        Assert.assertTrue(StringUtils.isInteger("0"));
        Assert.assertTrue(StringUtils.isInteger("99999"));
    }


    @Test
    public void isIntegerReturnsTrueForNegativeInteger() {
        Assert.assertTrue(StringUtils.isInteger("-1"));
        Assert.assertTrue(StringUtils.isInteger("-9999999"));
    }

    @Test
    public void isIntegerReturnsFalseForEmptyString() {
        Assert.assertFalse(StringUtils.isInteger(""));
    }

    @Test
    public void isIntegerReturnsFalseForString() {
        Assert.assertFalse(StringUtils.isInteger("hello"));
        Assert.assertFalse(StringUtils.isInteger("-"));
    }
}
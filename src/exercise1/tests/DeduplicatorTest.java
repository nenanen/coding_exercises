package exercise1.tests;

import exercise1.main.Deduplicator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static java.util.Collections.emptyList;

@RunWith(JUnit4.class)
public class DeduplicatorTest {

    @Test
    public void handlesEmptyList() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(emptyList());
        List<String> expected = emptyList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesNoDuplicates() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a"));
        List<String> expected = emptyList();
        Assert.assertEquals(expected, actual);

        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "c", "d"));
        expected = emptyList();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void handlesOneDuplicates() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "a"));
        List<String> expected = List.of("a");
        Assert.assertEquals(expected, actual);

        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "a"));
        expected = List.of("a");
        Assert.assertEquals(expected, actual);

        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("aaaa", "a", "aa", "a", "aaa"));
        expected = List.of("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesMultipleDuplicates() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "a", "b", "c"));
        List<String> expected = List.of("a", "b");

        Assert.assertEquals(expected, actual);


        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("ab", "ba", "ab", "bb", "ba", "ca"));
        expected = List.of("ab", "ba");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesMultipleDuplicatesInOrderOfAppearance() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "b", "a", "c"));
        List<String> expected = List.of("a", "b");
        Assert.assertEquals(expected, actual);


        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"));
        expected = List.of("a", "c", "d");
        Assert.assertEquals(expected, actual);
    }
}
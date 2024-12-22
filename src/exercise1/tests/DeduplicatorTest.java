package exercise1.tests;

import exercise1.main.Deduplicator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;


class DeduplicatorTest {

    @Test
    void handlesEmptyList() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(emptyList());
        List<String> expected = emptyList();
        assertEquals(expected, actual);
    }

    @Test
    void handlesNoDuplicates() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a"));
        List<String> expected = emptyList();
        assertEquals(expected, actual);

        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "c", "d"));
        expected = emptyList();
        assertEquals(expected, actual);
    }


    @Test
    void handlesOneDuplicates() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "a"));
        List<String> expected = List.of("a");
        assertEquals(expected, actual);

        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "a"));
        expected = List.of("a");
        assertEquals(expected, actual);
    }

    @Test
    void handlesMultipleDuplicates() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "a", "b", "c"));
        List<String> expected = List.of("a", "b");

        assertEquals(expected, actual);
    }

    @Test
    void handlesMultipleDuplicatesInOrderOfAppearance() {
        List<String> actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("a", "b", "b", "a", "c"));
        List<String> expected = List.of("a", "b");
        assertEquals(expected, actual);


        actual = Deduplicator.getDuplicatesInOriginalOrder(List.of("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"));
        expected = List.of("a", "c", "d");
        assertEquals(expected, actual);
    }
}
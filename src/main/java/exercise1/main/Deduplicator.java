package exercise1.main;

import java.util.*;


public class Deduplicator {

    /**
     * Given a list of elements, it returns a list that contains only those that are duplicated, in the order that they
     * appeared for the first time in the original list.
     *
     * @param elements the input list of elements
     * @return a list of duplicate elements, sorted by their initial occurrence in the input
     */
    public static List<String> getDuplicatesInOriginalOrder(List<String> elements) {
        Map<String, Integer> firstOccurrences = new HashMap<>(); // stores an element and the index of its first occurrence
        Map<String, Integer> duplicates = new HashMap<>(); // stores a duplicate element and the index of its first occurrence

        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i);
            if (firstOccurrences.containsKey(element)) {
                duplicates.putIfAbsent(element, firstOccurrences.get(element));
            } else {
                firstOccurrences.put(element, i);
            }
        }

        return duplicates.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // sort the elements by the value aka the index of its first occurrence
                .map(Map.Entry::getKey)
                .toList();
    }
}
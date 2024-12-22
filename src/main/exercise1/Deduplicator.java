package main.exercise1;

import java.util.*;


public class Deduplicator {

    /**
     * Retrieves duplicate elements from the input list and returns them in the order of their first appearance.
     *
     * @param elements the input list of elements
     * @return a list of duplicate elements, sorted by their initial occurrence in the input
     */
    public static List<String> getDuplicates(List<String> elements) {
        Map<String, Integer> firstOccurrences = new HashMap<>();
        Map<String, Integer> duplicates = new HashMap<>();


        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i);
            if (firstOccurrences.containsKey(element)) {
                duplicates.putIfAbsent(element, firstOccurrences.get(element));
            } else {
                firstOccurrences.put(element, i);
            }
        }

        return duplicates.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();
    }
}
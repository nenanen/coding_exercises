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
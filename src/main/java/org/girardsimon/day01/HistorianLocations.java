package org.girardsimon.day01;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record HistorianLocations(List<Integer> locationsLeft, List<Integer> locationsRight) {
    public HistorianLocations {
        locationsLeft = List.copyOf(locationsLeft);
        locationsRight = List.copyOf(locationsRight);
    }

    public int computeDistance() {
        List<Integer> sortedLocationsLeft = locationsLeft.stream()
                .sorted()
                .toList();
        List<Integer> sortedLocationsRight = locationsRight.stream()
                .sorted()
                .toList();

        return IntStream.range(0, getLocationsSize())
                .map(i -> Math.abs(sortedLocationsLeft.get(i) - sortedLocationsRight.get(i)))
                .sum();
    }

    public long computeSimilarityScore() {
        Map<Integer, Long> rightValuesAndNumberOfOccurrences = locationsRight.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return locationsLeft.stream()
                .mapToLong(i -> i * rightValuesAndNumberOfOccurrences.getOrDefault(i, 0L))
                .sum();
    }

    private int getLocationsSize() {
        return Math.min(locationsLeft.size(), locationsRight.size());
    }
}

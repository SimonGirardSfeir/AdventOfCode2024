package org.girardsimon.day01;

import java.util.ArrayList;
import java.util.List;

public final class LocationsParser {
    private LocationsParser() {
    }

    public static HistorianLocations parseHistorianLocations(List<String> lines) {
        List<Integer> firstGroup = new ArrayList<>(lines.size());
        List<Integer> secondGroup = new ArrayList<>(lines.size());

        lines.forEach(line -> parseLine(line, firstGroup, secondGroup));
        return new HistorianLocations(firstGroup, secondGroup);
    }

    private static void parseLine(String line, List<Integer> firstGroup, List<Integer> secondGroup) {
        String[] parts = line.split("\\s+");
        firstGroup.add(Integer.parseInt(parts[0]));
        secondGroup.add(Integer.parseInt(parts[1]));
    }
}

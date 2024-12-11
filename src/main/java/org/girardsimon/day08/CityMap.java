package org.girardsimon.day08;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record CityMap(List<Antenna> antennas, int maxHeight, int maxWidth) {

    public Map<Character, List<Antenna>> getAntennasGroupedByFrequency() {
        return antennas.stream()
                .collect(Collectors.groupingBy(Antenna::frequency));
    }
}
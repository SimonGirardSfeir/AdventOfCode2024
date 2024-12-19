package org.girardsimon.day12;

import org.girardsimon.common.Position;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class GardenParser {
    private GardenParser() {
    }

    public static Garden parseGarden(List<String> lines) {
        int maxHeight = lines.size();
        int maxWidth = lines.getFirst().length();
        Set<Plant> plants = IntStream.range(0, maxWidth)
                .boxed()
                .flatMap(col ->
                        IntStream.range(0, maxHeight)
                                .mapToObj(row -> new Plant(lines.get(row).charAt(col),
                                        new Position(col, maxHeight - row - 1)))
                )
                .collect(Collectors.toSet());
        return new Garden(plants);
    }
}

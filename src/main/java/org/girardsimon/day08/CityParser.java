package org.girardsimon.day08;

import org.girardsimon.common.Position;

import java.util.List;
import java.util.stream.IntStream;

public final class CityParser {
    private CityParser() {
    }

    public static CityMap parseCity(List<String> lines) {
        int maxHeight = lines.size();
        int maxWidth = lines.getFirst().length();
        List<Antenna> antennas = IntStream.range(0, maxWidth)
                .boxed()
                .flatMap(col ->
                        IntStream.range(0, maxHeight)
                                .filter(row -> Character.isLetterOrDigit(lines.get(row).charAt(col)))
                                .mapToObj(row -> new Antenna(
                                        lines.get(row).charAt(col),
                                        new Position(col, maxHeight - row - 1)))
                )
                .toList();
        return new CityMap(antennas, maxHeight, maxWidth);
    }
}

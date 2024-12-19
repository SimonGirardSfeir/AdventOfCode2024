package org.girardsimon.day10;

import org.girardsimon.common.Position;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TopographicMapParser {
    private TopographicMapParser() {
    }

    public static TopographicMap parseTopographicMap(List<String> lines) {
        int maxHeight = lines.size();
        int maxWidth = lines.getFirst().length();
        Set<TopographicMapPosition> mapPositions = IntStream.range(0, maxWidth)
                .boxed()
                .flatMap(col ->
                        IntStream.range(0, maxHeight)
                                .mapToObj(row -> new TopographicMapPosition(
                                        getHeight(lines, col, row),
                                        new Position(col, maxHeight - row - 1)))
                )
                .collect(Collectors.toSet());
        return new TopographicMap(mapPositions);
    }

    private static int getHeight(List<String> lines, Integer col, int row) {
        if(lines.get(row).charAt(col) == '.') {
            return -1;
        }
        return Integer.parseInt(String.valueOf(lines.get(row).charAt(col)));
    }
}

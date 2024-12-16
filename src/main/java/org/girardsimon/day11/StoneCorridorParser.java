package org.girardsimon.day11;

import java.util.Arrays;
import java.util.List;

public final class StoneCorridorParser {
    private StoneCorridorParser() {
    }

    public static StoneCorridor parseStoneCorridor(String line) {
        List<Stone> stones = Arrays.stream(line.split(" "))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Stone::new)
                .toList();
        return new StoneCorridor(stones);
    }
}

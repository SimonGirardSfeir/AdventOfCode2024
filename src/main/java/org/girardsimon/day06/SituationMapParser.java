package org.girardsimon.day06;

import org.girardsimon.common.Direction4;
import org.girardsimon.common.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public final class SituationMapParser {

    private static final char OBSTACLE_CHAR = '#';
    private static final char NORTH_CHAR = '^';
    private static final char EAST_CHAR = '>';
    private static final char SOUTH_CHAR = 'v';
    private static final char WEST_CHAR = '<';

    private SituationMapParser() {
    }

    public static SituationMap parseSituationMap(List<String> lines) {
        int maxWidth = lines.getFirst().length();
        int maxHeight = lines.size();
        List<Guard> guards = new ArrayList<>();
        Set<Position> obstacles = new HashSet<>();
        IntStream.range(0, maxHeight).forEach(row -> IntStream.range(0, maxWidth).forEach(col -> {
            char currentChar = lines.get(row).charAt(col);
            if(currentChar == OBSTACLE_CHAR) {
                obstacles.add(new Position(col, maxWidth - row - 1));
            } else if(currentChar == EAST_CHAR || currentChar == NORTH_CHAR || currentChar == SOUTH_CHAR || currentChar == WEST_CHAR){
                guards.add(setGuardSituation(maxWidth - row -1, col, currentChar));
            }
        }));
        return new SituationMap(obstacles, guards.getFirst(), maxHeight, maxWidth);
    }

    private static Guard setGuardSituation(int row, int col, char currentChar) {
        return switch (currentChar) {
            case NORTH_CHAR -> new Guard(new Position(col, row), Direction4.NORTH);
            case EAST_CHAR -> new Guard(new Position(col, row), Direction4.EAST);
            case SOUTH_CHAR -> new Guard(new Position(col, row), Direction4.SOUTH);
            case WEST_CHAR -> new Guard(new Position(col, row), Direction4.WEST);
            default -> throw new IllegalStateException("Unexpected value: " + currentChar);
        };
    }
}

package org.girardsimon.day04;

import org.girardsimon.common.Direction8;
import org.girardsimon.common.Position;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.girardsimon.common.CoordinateSystem.STANDARD;

public record MonitoringStation(Map<Position, StationLetter> stationLetters, int maxHeight, int maxWidth) {

    public long countXmasOccurrences() {
        return stationLetters.entrySet().stream()
                .filter(entry -> entry.getValue() == StationLetter.X)
                .mapToLong(entry -> numberOfXmasStartingAtPosition(entry.getKey()))
                .sum();
    }

    private long numberOfXmasStartingAtPosition(Position position) {
        return Arrays.stream(Direction8.values())
                .filter(direction -> hasPatternForDirection(direction, position))
                .count();
    }

    private boolean hasPatternForDirection(Direction8 direction, Position position) {
        return stationLetters.get(position.fromDelta(direction.dx(STANDARD), direction.dy(STANDARD))) == StationLetter.M
        && stationLetters.get(position.fromDelta(2 * direction.dx(STANDARD), 2 * direction.dy(STANDARD))) == StationLetter.A
        && stationLetters.get(position.fromDelta(3 * direction.dx(STANDARD), 3 * direction.dy(STANDARD))) == StationLetter.S;
    }

    public long countXshapeMasOccurrences() {
        return stationLetters.entrySet().stream()
                .filter(entry -> entry.getValue() == StationLetter.A && isXShapeMAS(entry.getKey()))
                .count();
    }

    private boolean isXShapeMAS(Position position) {
        if(position.x() == maxWidth || position.y() == maxHeight || position.x() == 0 || position.y() == 0) {
            return false;
        }
        Set<StationLetter> primaryDiagonal = Stream.of(position.fromDelta(-1,-1), position.fromDelta(1,1))
                .map(stationLetters::get)
                .collect(Collectors.toSet());
        Set<StationLetter> secondaryDiagonal = Stream.of(position.fromDelta(-1,1), position.fromDelta(1,-1))
                .map(stationLetters::get)
                .collect(Collectors.toSet());

        return Stream.of(StationLetter.M, StationLetter.S)
                .allMatch(primaryDiagonal::contains)
                && Stream.of(StationLetter.M, StationLetter.S)
                .allMatch(secondaryDiagonal::contains);
    }
}

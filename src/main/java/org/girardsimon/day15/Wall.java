package org.girardsimon.day15;

import org.girardsimon.common.Position;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Wall(Position position, int width, Set<Position> occupiedPositions) {
    public Wall(Position position, int width) {
        this(position, width, IntStream.range(0, width)
                .boxed()
                .map(i -> position.fromDelta(i, 0))
                .collect(Collectors.toSet()));
    }
}
